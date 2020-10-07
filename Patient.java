import java.util.Scanner;

public class Patient extends Hospital {
    static int lastPatientId;
    int patientId;
    String patientName;
    String patientInsuranceNumber;
    String patientAddress;
    String patientSymptoms;
    String patientPhoneNumber;

    public Patient(){
        lastPatientId++;
        patientId = lastPatientId;
    }

    public Patient(String patientName, String patientInsuranceNumber, String patientAddress, String patientSymptoms, String patientPhoneNumber) {
        lastPatientId++;
        this.patientId = lastPatientId;
        this.patientName = patientName;
        this.patientInsuranceNumber = patientInsuranceNumber;
        this.patientAddress = patientAddress;
        this.patientSymptoms = patientSymptoms;
        this.patientPhoneNumber = patientPhoneNumber;
    }

    @Override
    public String toString() {
        return "Patient {" +
                "patientId = " + patientId +
                ", patientName = '" + patientName + '\'' +
                ", patientInsuranceNumber = '" + patientInsuranceNumber + '\'' +
                ", patientAddress = '" + patientAddress + '\'' +
                ", patientSymptoms = '" + patientSymptoms + '\'' +
                ", patientPhoneNumber = '" + patientPhoneNumber + '\'' +
                '}';
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientInsuranceNumber() {
        return patientInsuranceNumber;
    }

    public void setPatientInsuranceNumber(String patientInsuranceNumber) {
        this.patientInsuranceNumber = patientInsuranceNumber;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientSymptoms() {
        return patientSymptoms;
    }

    public void setPatientSymptoms(String patientSymptoms) {
        this.patientSymptoms = patientSymptoms;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }
    // This Takes Input From The User
    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Patient Name.");
        patientName = scanner.nextLine();
        System.out.println("Enter Patient Insurance Number.");
        patientInsuranceNumber = scanner.nextLine();
        System.out.println("Enter patient Symptoms.");
        patientSymptoms = scanner.nextLine();
        System.out.println("Enter Patient Address.");
        patientAddress = scanner.nextLine();
        System.out.println("Enter Patient PhoneNumber.");
        patientPhoneNumber = scanner.nextLine();
    }
}
