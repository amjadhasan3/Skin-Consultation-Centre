import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIPage1 extends JFrame {

    public static ArrayList<Doctor> doctorArrayList;
    public static void doctorListDataTransfer(ArrayList<Doctor> doctorList) {
        doctorArrayList = doctorList;
    }

    GUIPage1()
    {
        JPanel panelMain = new JPanel(new GridLayout(2,1));
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

        int i = 0;
        for (Doctor value : doctorArrayList) {
            model.insertRow(i,new String[]{value.getFirstname(),value.getSurname(),String.valueOf(value.getDateOfBirth()), Long.toString(value.getMobileNumber()), Integer.toString(value.getMedicalLicenceNumber()), value.getSpecialisation()});
            i++;
        }

        JScrollPane scrollPane = new JScrollPane(table);
        panelMain.add(scrollPane);

        JButton sortBtn = new JButton("Sort The Table");
        gridEdit.gridx = 1;
        gridEdit.gridy = 0;
        panelBottom.add(sortBtn,gridEdit);

        JButton bookBtn = new JButton("Book A Doctor");
        gridEdit.gridx = 1;
        gridEdit.gridy = 1;
        panelBottom.add(bookBtn,gridEdit);

        panelMain.add(panelBottom);

        JFrame frame= new JFrame();
        frame.setTitle("List of Doctors");
        frame.setVisible(true);
        frame.setSize(700, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panelMain);

        bookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GUIPage2();
            }
        });

        sortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUISortDoctorTable.doctorlistDataTransfer(doctorArrayList);
                frame.setVisible(false);
                new GUISortDoctorTable();
            }
        });
    }
}
