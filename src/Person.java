import java.io.Serializable;

public class Person implements Serializable {

    protected String Firstname;
    protected String Surname;
    protected String dateOfBirth;
    protected int mobileNumber;

    public Person(String firstname, String surname, String dateOfBirth, int mobileNumber) {
        this.Firstname = firstname;
        this.Surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }
    // Getters and Setters
    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }
    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getMobileNumber() {return mobileNumber;}

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}
