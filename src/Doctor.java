import java.io.Serializable;

public class Doctor  extends Person implements Serializable{
    private int medicalLicenceNumber;
    private String specialisation;

    public Doctor(String firstname, String surname, String dateOfBirth, int mobileNumber, int medicalLicenceNumber, String specialisation) {
        super(firstname, surname, dateOfBirth, mobileNumber);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;
    }

    public int getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public void setMedicalLicenceNumber(int medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
