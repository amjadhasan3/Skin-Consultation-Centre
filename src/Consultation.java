public class Consultation {
    String date;
    float cost;
    String note;
    int doctorLicenceNo;
    int patientID;

    public Consultation(String date, float cost, String note, int doctorLicenceNo, int patientID) {
        this.date = date;
        this.cost = cost;
        this.note = note;
        this.doctorLicenceNo = doctorLicenceNo;
        this.patientID = patientID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDoctorLicenceNum() {
        return doctorLicenceNo;
    }

    public void setDoctorLicenceNum(int doctorLicenceNum) {
        this.doctorLicenceNo = doctorLicenceNum;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

}
