import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PatientConsultationDetails {

    private static int patientId;

    private String patientFullName;

    public static void patientIdDataTransfer(int patId) {
        patientId = patId;
    }

    public PatientConsultationDetails() {
        JPanel panelMain = new JPanel(new GridLayout(2,1));
        JPanel panelGrid = new JPanel(new GridBagLayout());


        panelMain.setBackground(new Color(173, 216, 230));
        panelGrid.setBackground(new Color(173, 216, 230));

        GridBagConstraints gridEdit = new GridBagConstraints();

        gridEdit.insets = new Insets(5, 5, 5, 5);
        gridEdit.fill = GridBagConstraints.VERTICAL;
        gridEdit.gridx = 0;
        gridEdit.gridy = 0;

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.setBounds(30, 40, 200, 300);


        model.addColumn("Doctor Medical licence number");
        model.addColumn("Patient Name");
        model.addColumn("Consultation date");
        model.addColumn("Consultation cost");
        model.addColumn("Consultation note");

        for (Patient value1 : WestminsterSkinConsultationManager.patients) {
            if (value1.getPatientId() == patientId) {
                patientFullName = value1.getFirstname()+" "+value1.getSurname();
            }
        }

        for (Consultation value : WestminsterSkinConsultationManager.consultations) {
            if (value.getPatientID() == patientId) {
                int i = 0;

                String encodedNote = value.getNote();
                byte[] decodedBytes = Base64.getDecoder().decode(encodedNote);
                String decodedNote= new String(decodedBytes, StandardCharsets.UTF_8);
                model.insertRow(i,new String[]{String.valueOf(value.getDoctorLicenceNum()), patientFullName, value.getDate(), String.valueOf(value.getCost()), decodedNote});
                ++i;
            }
        }

        JScrollPane scrollPane = new JScrollPane(table);
        panelMain.add(scrollPane);


        JButton homeBtn = new JButton("Home");
        gridEdit.gridx = 1;
        gridEdit.gridy = 1;
        panelGrid.add(homeBtn,gridEdit);

        panelMain.add(panelGrid);


        JFrame frame = new JFrame();
        frame.setTitle("Patient Details");
        frame.setVisible(true);
        frame.setSize(700, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panelMain);

        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GUIStart();
            }
        });
    }
}
