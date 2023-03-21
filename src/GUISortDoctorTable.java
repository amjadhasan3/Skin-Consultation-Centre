import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUISortDoctorTable {
    public static ArrayList<Doctor> doctorList;

    public static void doctorlistDataTransfer(ArrayList<Doctor> doctorList2) {
        doctorList = doctorList2;
    }

    GUISortDoctorTable () {
        JPanel panelSort = new JPanel(new GridLayout(2,1));

        JPanel panelBottom = new JPanel(new GridBagLayout());
        panelBottom.setBackground(new Color(173, 216, 230));

        GridBagConstraints gridEdit = new GridBagConstraints();

        gridEdit.insets = new Insets(5, 5, 5, 5);
        gridEdit.fill = GridBagConstraints.VERTICAL;
        gridEdit.gridx = 0;
        gridEdit.gridy = 0;

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.setBounds(30, 40, 200, 300);

        model.addColumn("First Name");
        model.addColumn("Surname");
        model.addColumn("Date of birth");
        model.addColumn("Mobile No");
        model.addColumn("Licence No");
        model.addColumn("Specialization");

        doctorList.sort(new SortDoctorFirstName());

        int i = 0;
        for (Doctor value : doctorList) {
            model.insertRow(i,new String[]{value.getFirstname(), value.getSurname(), String.valueOf(value.getDateOfBirth()), Long.toString(value.getMobileNumber()), Integer.toString(value.getMedicalLicenceNumber()), value.getSpecialisation()});
            i++;
        }

        JScrollPane scrollPane = new JScrollPane(table);
        panelSort.add(scrollPane);

        JButton backBtn = new JButton("Back");
        gridEdit.gridx = 1;
        gridEdit.gridy = 0;
        panelBottom.add(backBtn,gridEdit);

        panelSort.add(panelBottom);


        JFrame frame = new JFrame();
        frame.setTitle("Alphabetical Order");
        frame.setVisible(true);
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panelSort);


        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GUIPage1();
            }
        });
    }
}

