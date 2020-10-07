import java.util.Scanner;

public class Consultations extends Hospital {



    int patientRegistrationNumber;
    int doctorId;
    String reasonOfVisit;
    String suggestedMedicine;
    String lab;
    String date;
    double cost;

    public Consultations() {

    }

    @Override
    public String toString() {
        return "Consultations{" +
                "patientRegistrationNumber=" + patientRegistrationNumber +
                ", doctorId=" + doctorId +
                ", reasonOfVisit='" + reasonOfVisit + '\'' +
                ", suggestedMedicine='" + suggestedMedicine + '\'' +
                ", lab='" + lab + '\'' +
                ", date='" + date + '\'' +
                ", cost=" + cost +
                '}';
    }

    public int getPatientRegistrationNumber() {
        return patientRegistrationNumber;
    }

    public void setPatientRegistrationNumber(int patientRegistrationNumber) {
        this.patientRegistrationNumber = patientRegistrationNumber;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getReasonOfVisit() {
        return reasonOfVisit;
    }

    public void setReasonOfVisit(String reasonOfVisit) {
        this.reasonOfVisit = reasonOfVisit;
    }

    public String getSuggestedMedicine() {
        return suggestedMedicine;
    }

    public void setSuggestedMedicine(String suggestedMedicine) {
        this.suggestedMedicine = suggestedMedicine;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    Double inputNumber() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean tryVar = false;
        Double number = -1d;
        do {
            try {
                tryVar = false;
                number = Double.parseDouble(input);
            } catch (Exception e) {
                tryVar = true;
                System.out.println("The Number Is Not Integer");
            }
        } while (tryVar);
        return number;
    }

    String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void input() {
        System.out.println("Enter Reason of visit");
        reasonOfVisit = inputString();
        System.out.println("Enter Suggested Medicine");
        suggestedMedicine = inputString();
        System.out.println("Enter Lab");
        lab = inputString();
        System.out.println("Enter Date (DD/MM/YYYY)");
        date = inputString();
        System.out.println("Enter Bill");
        cost = inputNumber();
    }
}
