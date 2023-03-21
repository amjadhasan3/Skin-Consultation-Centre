import java.io.Serializable;

public class Patient extends Person implements Serializable {
    private int patientId;
    private String password;

    public Patient(String firstname, String surname, String dateOfBirth, int mobileNumber, int patientId, String password) {
        super(firstname, surname, dateOfBirth, mobileNumber);
        this.patientId = patientId;
        this.password = password;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
