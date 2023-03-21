import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class PatientLogin {

    PatientLogin() {
        JPanel panelMain = new JPanel(new GridBagLayout());
        panelMain.setBackground(new Color(173, 216, 230));

        GridBagConstraints gridEdit = new GridBagConstraints();

        gridEdit.insets = new Insets(5, 5, 5, 5);
        gridEdit.gridx = 0;
        gridEdit.gridy = 0;

        JLabel patientIdL= new JLabel("Patient ID");
        gridEdit.gridx = 0;
        gridEdit.gridy = 1;
        panelMain.add(patientIdL,gridEdit);

        JTextField patientIdT = new JTextField(5);
        gridEdit.gridx = 1;
        gridEdit.gridy = 1;
        patientIdT.setMinimumSize(patientIdT.getPreferredSize());
        panelMain.add(patientIdT,gridEdit);

        JLabel patientPasswordL = new JLabel("Password");
        gridEdit.gridx = 0;
        gridEdit.gridy = 2;
        panelMain.add(patientPasswordL,gridEdit);

        JTextField patientPasswordT = new JTextField(10);
        gridEdit.gridx = 1;
        gridEdit.gridy = 2;
        patientPasswordT.setMinimumSize(patientPasswordT.getPreferredSize());
        panelMain.add(patientPasswordT,gridEdit);

        JButton showBtn = new JButton("Show");
        gridEdit.gridx = 1;
        gridEdit.gridy = 3;
        panelMain.add(showBtn,gridEdit);

        JFrame frame = new JFrame();
        frame.setTitle("Login");
        frame.setVisible(true);
        frame.setSize(500, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panelMain);

        showBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = true;
                if (patientIdT.getText().equals("")) {
                    showMessageDialog(patientIdT, "Enter the patient ID");
                } else if (patientPasswordT.getText().equals("")) {
                    showMessageDialog(patientPasswordT,"Enter the password");
                } else {
                    try {
                        int patId = Integer.parseInt(patientIdT.getText());
                        String patPassword = patientPasswordT.getText();
                        PatientConsultationDetails.patientIdDataTransfer(patId);
                        for (Patient value : WestminsterSkinConsultationManager.patients) {
                            if (value.getPatientId() == patId && value.getPassword().equals(patPassword)) {
                                frame.setVisible(false);
                                new PatientConsultationDetails();
                                check = false;
                            }
                        }
                        if (check) {
                            JOptionPane.showMessageDialog(showBtn,"Patient ID or Password entered is invalid");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(patientIdT,"Invalid Input");
                    }
                }
            }
        });
    }
}
