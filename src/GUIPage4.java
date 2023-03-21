import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIPage4 {
    private static String PatientFirstName;
    private static String PatientSurName;
    private static String PatientDOB;
    private static long PatientMobileNo;
    private static int PatientId;
    private static String PatientPassword;

    private static int ConsultHour;
    private static String ConsultDate;
    private static String ConsultNote;
    private static int ConsultCost;

    private static int DoctorMedLicNum;
    private static String DoctorFullName;

    public static ArrayList<Doctor> doctorList;

    String message;

    public static void doctorListDataTransfer(ArrayList<Doctor> doctorList2) {
        doctorList = doctorList2;
    }

    public static void patientDataTransfer(String patientfirstname, String patientsurname, String patientdob, long patientmobno, int patientid, String patientpassword) {
        PatientFirstName = patientfirstname;
        PatientSurName = patientsurname;
        PatientDOB = patientdob;
        PatientMobileNo = patientmobno;
        PatientId = patientid;
        PatientPassword = patientpassword;
    }

    public static void consultationDataTransfer(int consultationhour, String consultationdate, String consultationnote) {
        ConsultHour = consultationhour;
        ConsultDate = consultationdate;
        ConsultNote = consultationnote;
    }

    public static void doctorDataTransfer(int doctormedlicnum, String doctorfullname) {
        DoctorMedLicNum = doctormedlicnum;
        DoctorFullName = doctorfullname;
    }

    GUIPage4() {
        Patient patient = new Patient(PatientFirstName, PatientSurName, PatientDOB, (int) PatientMobileNo, PatientId, PatientPassword);

        WestminsterSkinConsultationManager.addToPatientList(patient);

        for (Patient value : WestminsterSkinConsultationManager.patients) {
            if (value.getPatientId() == PatientId) {
                ConsultCost = 25 * ConsultHour;
            } else {
                ConsultCost = 15 + (ConsultHour - 1) * 25;
            }
        }

        //doctor availability
        boolean available = checkDoctorAvailability(DoctorMedLicNum, ConsultDate);

        if (available) {
            message = "Consultation is booked";
            Consultation consultation = new Consultation(ConsultDate, ConsultCost, ConsultNote, DoctorMedLicNum, PatientId);
            WestminsterSkinConsultationManager.addToConsultationList(consultation);
        } else {
            message = "The doctor you have chosen not available on that day.\nTherefore another doctor is allocated";
            int randomMedLicNo;
            String randomDoctorFullName;
            do {
                int randomIndex = (int) (Math.random() * doctorList.size());
                Doctor randomDoctor = doctorList.get(randomIndex);
                randomDoctorFullName = randomDoctor.getFirstname()+" "+randomDoctor.getSurname();
                randomMedLicNo = randomDoctor.getMedicalLicenceNumber();
                available = checkDoctorAvailability(randomMedLicNo, ConsultDate);
            } while (!available);

            // Doctor full name assigning
            DoctorMedLicNum = randomMedLicNo;
            // Doctor medical licence number assigning
            DoctorFullName = randomDoctorFullName;

            Consultation consultation = new Consultation(ConsultDate, ConsultCost, ConsultNote, DoctorMedLicNum, PatientId);
            WestminsterSkinConsultationManager.addToConsultationList(consultation);
        }


        JPanel panelMain = new JPanel(new GridBagLayout());
        panelMain.setBackground(new Color(173, 216, 230));

        GridBagConstraints gridEdit = new GridBagConstraints();

        gridEdit.insets = new Insets(5, 5, 5, 5);
        gridEdit.gridx = 0;
        gridEdit.gridy = 0;

        JLabel confirmation = new JLabel(message);
        gridEdit.gridx = 1;
        gridEdit.gridy = 0;
        confirmation.setSize(300,100);
        panelMain.add(confirmation,gridEdit);

        JLabel doctorFullNameL = new JLabel("Doctor Name");
        gridEdit.gridx = 0;
        gridEdit.gridy = 1;
        panelMain.add(doctorFullNameL,gridEdit);

        JLabel doctorFullName= new JLabel(DoctorFullName);
        gridEdit.gridx = 1;
        gridEdit.gridy = 1;
        panelMain.add(doctorFullName,gridEdit);

        JLabel patientFullNameL= new JLabel("Patient Name");
        gridEdit.gridx = 0;
        gridEdit.gridy = 2;
        panelMain.add(patientFullNameL,gridEdit);

        JLabel patientFullName = new JLabel(PatientFirstName+" "+PatientSurName);
        gridEdit.gridx = 1;
        gridEdit.gridy = 2;
        panelMain.add(patientFullName,gridEdit);

        JLabel consultFeeL = new JLabel("Consultation Fee");
        gridEdit.gridx = 0;
        gridEdit.gridy = 3;
        panelMain.add(consultFeeL,gridEdit);

        JLabel consultFee = new JLabel(String.valueOf(ConsultCost));
        gridEdit.gridx = 1;
        gridEdit.gridy = 3;
        panelMain.add(consultFee,gridEdit);

        JButton homeBtn = new JButton("Home");
        gridEdit.gridx = 1;
        gridEdit.gridy = 4;
        panelMain.add(homeBtn,gridEdit);

        JButton closeBtn = new JButton("Close");
        gridEdit.gridx = 1;
        gridEdit.gridy = 5;
        panelMain.add(closeBtn,gridEdit);

        JFrame frame = new JFrame();
        frame.setTitle("Confirmation");
        frame.setVisible(true);
        frame.setSize(700, 400);
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

        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }

    private boolean checkDoctorAvailability(int doctorLicenceNum, String consultationDate) {
        for (Consultation value : WestminsterSkinConsultationManager.consultations) {
            if (value.getDoctorLicenceNum() == doctorLicenceNum && value.getDate().equals(consultationDate)) {
                return false;
            }
        }
        return true;
    }

}


