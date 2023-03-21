import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import static javax.swing.JOptionPane.showMessageDialog;

public class GUIPage3 {
    private static int doctorMedicalLicNo;
    private static String doctorName;

    public static void doctorMedicalLicNoTransfer (int number) {
        doctorMedicalLicNo =  number;
    }

    GUIPage3() {
        JPanel panelMain = new JPanel(new GridBagLayout());
        panelMain.setBackground(new Color(173, 216, 230));

        GridBagConstraints gridEdit = new GridBagConstraints();

        gridEdit.insets = new Insets(5, 50, 5, 50);
        gridEdit.gridx = 0;
        gridEdit.gridy = 0;

        JLabel doctorMLNL = new JLabel("Medical Licence No");
        gridEdit.gridx = 0;
        gridEdit.gridy = 0;
        panelMain.add(doctorMLNL,gridEdit);

        JLabel doctorMLN = new JLabel(String.valueOf(doctorMedicalLicNo));
        gridEdit.gridx = 1;
        gridEdit.gridy = 0;
        panelMain.add(doctorMLN,gridEdit);

        JLabel doctorFNameL = new JLabel("Doctor Name");
        gridEdit.gridx = 0;
        gridEdit.gridy = 1;
        panelMain.add(doctorFNameL,gridEdit);

        for (Doctor value: GUIPage1.doctorArrayList) {
            if (value.getMedicalLicenceNumber() == doctorMedicalLicNo) {
                doctorName = value.getFirstname()+" "+value.getSurname();
            }
        }

        JLabel doctorFName = new JLabel(doctorName);
        gridEdit.gridx = 1;
        gridEdit.gridy = 1;
        panelMain.add(doctorFName,gridEdit);

        JLabel patientFNameL = new JLabel("Patient Name");
        gridEdit.gridx = 0;
        gridEdit.gridy = 2;
        panelMain.add(patientFNameL,gridEdit);

        JTextField patientFNameT = new JTextField(10);
        gridEdit.gridx = 1;
        gridEdit.gridy = 2;
        gridEdit.weightx = 1;
        patientFNameT.setMinimumSize(patientFNameT.getPreferredSize());
        panelMain.add(patientFNameT,gridEdit);

        JLabel patientSNameL = new JLabel("Patient surname");
        gridEdit.gridx = 0;
        gridEdit.gridy = 3;
        panelMain.add(patientSNameL,gridEdit);

        JTextField patientSNameT = new JTextField(10);
        gridEdit.gridx = 1;
        gridEdit.gridy = 3;
        gridEdit.weightx = 1;
        patientSNameT.setMinimumSize(patientSNameT.getPreferredSize());
        panelMain.add(patientSNameT,gridEdit);

        JLabel patientDobL = new JLabel("Patient Date of Birth (YYYY/MM/DD)");
        gridEdit.gridx = 0;
        gridEdit.gridy = 4;
        panelMain.add(patientDobL,gridEdit);

        JTextField patientDobT = new JTextField(10);
        gridEdit.gridx = 1;
        gridEdit.gridy = 4;
        gridEdit.weightx = 1;
        patientDobT.setMinimumSize(patientDobT.getPreferredSize());
        panelMain.add(patientDobT,gridEdit);

        JLabel patientMNoL = new JLabel("Patient Mobile No.");
        gridEdit.gridx = 0;
        gridEdit.gridy = 5;
        panelMain.add(patientMNoL,gridEdit);

        JTextField patientMNoT = new JTextField(10);
        gridEdit.gridx = 1;
        gridEdit.gridy = 5;
        gridEdit.weightx = 1;
        patientMNoT.setMinimumSize(patientMNoT.getPreferredSize());
        panelMain.add(patientMNoT,gridEdit);

        JLabel patientIdL = new JLabel("Patient ID");
        gridEdit.gridx = 0;
        gridEdit.gridy = 6;
        panelMain.add(patientIdL,gridEdit);

        JTextField patientIdT = new JTextField(10);
        gridEdit.gridx = 1;
        gridEdit.gridy = 6;
        gridEdit.weightx = 1;
        patientIdT.setMinimumSize(patientIdT.getPreferredSize());
        panelMain.add(patientIdT,gridEdit);

        //consultation hour
        JLabel consultHourL = new JLabel("Consultation Hour");
        gridEdit.gridx = 0;
        gridEdit.gridy = 7;
        panelMain.add(consultHourL,gridEdit);

        JTextField consultHourT = new JTextField(5);
        gridEdit.gridx = 1;
        gridEdit.gridy = 7;
        gridEdit.weightx = 1;
        consultHourT.setMinimumSize(consultHourT.getPreferredSize());
        panelMain.add(consultHourT,gridEdit);

        //consultation date
        JLabel consultDateL = new JLabel("Consultation Date (YYYY/MM/DD)");
        gridEdit.gridx = 0;
        gridEdit.gridy = 8;
        panelMain.add(consultDateL,gridEdit);

        JTextField consultDateT = new JTextField(10);
        gridEdit.gridx = 1;
        gridEdit.gridy = 8;
        gridEdit.weightx = 1;
        consultDateT.setMinimumSize(consultDateT.getPreferredSize());
        panelMain.add(consultDateT,gridEdit);

        //consultation note
        JLabel consultNoteL = new JLabel("Consultation Note");
        gridEdit.gridx = 0;
        gridEdit.gridy = 9;
        panelMain.add(consultNoteL,gridEdit);

        JTextArea consultNoteT = new JTextArea(5,20);
        consultNoteT.setLineWrap(true);
        gridEdit.gridx = 1;
        gridEdit.gridy = 9;
        gridEdit.weightx = 1;
        consultNoteT.setMinimumSize(consultNoteT.getPreferredSize());
        panelMain.add(consultNoteT,gridEdit);

        JLabel patientPasswordL = new JLabel("Password");
        gridEdit.gridx = 0;
        gridEdit.gridy = 10;
        panelMain.add(patientPasswordL,gridEdit);

        JTextField patientPasswordT = new JTextField(10);
        gridEdit.gridx = 1;
        gridEdit.gridy = 10;
        gridEdit.weightx = 1;
        patientPasswordT.setMinimumSize(patientPasswordT.getPreferredSize());
        panelMain.add(patientPasswordT,gridEdit);

        JButton saveBtn= new JButton("Save Details");
        gridEdit.gridx = 1;
        gridEdit.gridy = 11;
        panelMain.add(saveBtn,gridEdit);

        JFrame frame = new JFrame();
        frame.setTitle("Patient Consultation Details");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panelMain); // Add panelMain to the frame

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientFirstName;
                String patientSurName;
                String patientDOB;
                long patientMobileNo;
                int patientId;
                String consultNote;
                String consultDate;
                int consultHour;
                String patientPassword;

                if (patientFNameT.getText().equals("")) {
                    showMessageDialog(patientFNameT,"Enter Patient Name");

                }else if (patientSNameT.getText().equals("")) {
                    showMessageDialog(patientSNameT,"Enter Patient Surname");

                } else if (patientDobT.getText().equals("")) {
                    showMessageDialog(patientDobT,"Enter Patient's Date Of Birth (YYYY/MM/DD)");

                } else if (patientMNoT.getText().equals("")) {
                    showMessageDialog(patientMNoT, "Enter Patient's Mobile No");

                } else if (patientIdT.getText().equals("")) {
                    showMessageDialog(patientIdT, "Enter Patient ID");

                } else if (consultHourT.getText().equals("")) {
                    showMessageDialog(consultHourT, "Enter Consultation Hours");

                }else if (consultDateT.getText().equals("")) {
                    showMessageDialog(consultDateT,"Enter Consultation Date (YYYY/MM/DD)");

                } else if (consultNoteT.getText().equals("")) {
                    showMessageDialog(consultNoteT,"Enter Note");

                } else if (patientPasswordT.getText().equals("")) {
                    showMessageDialog(consultNoteT,"Enter Password");
                } else {
                    patientFirstName = patientFNameT.getText();
                    patientSurName = patientSNameT.getText();
                    patientPassword = patientPasswordT.getText();

                    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                    Date date;

                    patientDOB = patientDobT.getText();
                    try {
                        date = df.parse(patientDOB);
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(patientDobT,"Invalid Input. Enter YYYY/MM/DD");
                    }

                    // Note encryption
                    consultNote = consultNoteT.getText();
                    String encodedconNote = Base64.getEncoder().encodeToString(consultNote.getBytes());


                    consultDate = consultDateT.getText();
                    try {
                        date = df.parse(consultDate);
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(consultDateT,"Invalid Input. Enter YYYY/MM/DD");
                    }

                    try {
                        patientMobileNo = Long.parseLong(patientMNoT.getText());
                        patientId = Integer.parseInt(patientIdT.getText());
                        consultHour = Integer.parseInt(consultHourT.getText());

                        GUIPage4.patientDataTransfer(patientFirstName,patientSurName,patientDOB,patientMobileNo,patientId,patientPassword);
                        GUIPage4.consultationDataTransfer(consultHour,consultDate,encodedconNote);
                        GUIPage4.doctorDataTransfer(doctorMedicalLicNo,doctorName);

                        frame.setVisible(false);
                        new GUIPage4();

                    } catch (NumberFormatException ex) {
                        showMessageDialog(patientMNoT,"Invalid Input");
                    }
                }
            }
        });
    }
}
