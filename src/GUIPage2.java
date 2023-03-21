import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class GUIPage2 {

    GUIPage2() {
        JPanel panelMain = new JPanel(new GridBagLayout());
        panelMain.setBackground(new Color(173, 216, 230));

        GridBagConstraints gridEdit = new GridBagConstraints();

        gridEdit.insets = new Insets(5, 50, 5, 50);
        gridEdit.gridx = 0;
        gridEdit.gridy = 0;

        //medical licence number
        JLabel medLicNoL = new JLabel("Enter Medical Licence Number");
        gridEdit.gridx = 0;
        gridEdit.gridy = 0;
        panelMain.add(medLicNoL,gridEdit);

        JTextField medLicNoT = new JTextField(5);
        gridEdit.gridx = 1;
        gridEdit.gridy = 0;
        gridEdit.weightx = 1;
        panelMain.add(medLicNoT,gridEdit);

        JButton bookBtn = new JButton("Enter");
        gridEdit.gridx = 1;
        gridEdit.gridy = 1;
        panelMain.add(bookBtn,gridEdit);

        JFrame frame = new JFrame();
        frame.setTitle("Enter Medical Licence");
        frame.setVisible(true);
        frame.setSize(500, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panelMain);
        new GUISortDoctorTable ();

        bookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = true;
                if (medLicNoT.getText().equals("")) {
                    showMessageDialog(medLicNoT, "Enter Medical license number");
                } else {
                    try {
                        int MedNo = Integer.parseInt(medLicNoT.getText());
                        GUIPage3.doctorMedicalLicNoTransfer(MedNo);
                        for (Doctor value : WestminsterSkinConsultationManager.doctors) {
                            if (value.getMedicalLicenceNumber() == MedNo) {
                                frame.setVisible(false);
                                new GUIPage3();
                                check = false;
                            }
                        }
                        if (check) {
                            JOptionPane.showMessageDialog(bookBtn,"This Medical Licence NUmber Does Not Exist");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(medLicNoT,"Invalid input.");
                    }
                }
            }
        });
    }
}
