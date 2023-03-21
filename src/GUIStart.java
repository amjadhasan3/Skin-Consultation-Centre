import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIStart extends JFrame {

    GUIStart() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(173, 216, 230));

        GridBagConstraints gridEdit = new GridBagConstraints();

        gridEdit.insets = new Insets(2, 2, 20, 2);
        gridEdit.fill = GridBagConstraints.VERTICAL;
        gridEdit.gridx = 0;
        gridEdit.gridy = 0;

        JLabel label = new JLabel("Westminster Skin Consultation");
        gridEdit.gridx = 1;
        gridEdit.gridy = 0;
        panel.add(label, gridEdit);

        JButton bookingBtn = new JButton("Doctor List");
        gridEdit.gridx = 1;
        gridEdit.gridy = 1;
        panel.add(bookingBtn, gridEdit);

        JButton patientLoginBtn = new JButton("Booked Consultations");
        gridEdit.gridx = 1;
        gridEdit.gridy = 2;
        panel.add(patientLoginBtn, gridEdit);

        JButton exitBtn = new JButton("Exit");
        gridEdit.gridx = 1;
        gridEdit.gridy = 3;
        panel.add(exitBtn, gridEdit);


        JFrame frame = new JFrame();
        frame.setTitle("Home Page");
        frame.setSize(500, 300);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

        bookingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GUIPage1();
            }
        });

        patientLoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (WestminsterSkinConsultationManager.patients.isEmpty()) {
                    JOptionPane.showMessageDialog(patientLoginBtn,"No Patients Have Been added.");
                } else {
                    frame.setVisible(false);
                    new PatientLogin();
                }
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
