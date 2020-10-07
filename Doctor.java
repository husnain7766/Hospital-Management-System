import java.util.Scanner;

public class Doctor extends Hospital {
    static int lastDoctorId =0;
    int doctorId;
    String doctorName;
    String doctorSpecialization;
    String doctorPhoneNumber;

    public Doctor(String doctorName, String doctorSpecialization, String doctorPhoneNumber) {
        lastDoctorId++;
        this.doctorId = lastDoctorId;
        this.doctorName = doctorName;
        this.doctorSpecialization = doctorSpecialization;
        this.doctorPhoneNumber = doctorPhoneNumber;
    }

    public Doctor(){
        lastDoctorId++;
        this.doctorId = lastDoctorId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId = " + doctorId +
                ", doctorName = '" + doctorName + '\'' +
                ", doctorSpecialization = '" + doctorSpecialization + '\'' +
                ", doctorPhoneNumber = '" + doctorPhoneNumber + '\'' +
                '}';
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    public String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    public void setDoctorPhoneNumber(String doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }

    void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Doctor Name.");
        this.doctorName = scanner.nextLine();
        System.out.println("Enter Doctor Specialization");
        this.doctorSpecialization = scanner.nextLine();
        System.out.println("Enter Doctor Phone Number");
        this.doctorPhoneNumber = scanner.nextLine();
    }
}
