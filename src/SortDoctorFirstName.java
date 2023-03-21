import java.util.Comparator;

public class SortDoctorFirstName implements Comparator<Doctor> {
    @Override
    public int compare(Doctor doctor1, Doctor doctor2) {
        return doctor1.getFirstname().compareTo(doctor2.getFirstname());
    }
}
