import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hospital {
    static List<Doctor> doctorList = new ArrayList<>();
    static List<Patient> patientList = new ArrayList<>();
    static List<LabTest> labTests = new ArrayList<>();
    static List<Consultations> consultationsList = new ArrayList<>();


    public static void main(String[] args) {
        Launch();
    }

    // input number
    static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean tryVar = false;
        int number = -1;
        do {
            try {
                tryVar = false;
                input = scanner.nextLine();
                number = Integer.parseInt(input);
            } catch (Exception e) {
                tryVar = true;
                System.out.println("The Number Is Not Integer");
            }
        } while (tryVar);
        return number;
    }

    static String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    // PATIENTS DETAILS;

    //This will add Now Patient
    static void addNewPatient() {
        Patient patient = new Patient();
        patient.input();
        patientList.add(patient);
    }

    //This will Print All Patients
    static void printAllPatients() {
        for (Patient patient : patientList) {
            System.out.println(patient);
        }
    }

    //This will search the patient on provided id;
    static void searchPatientById() {
        System.out.println("Enter Patient ID");
        int i = inputNumber();
        for (Patient patient : patientList) {
            if (patient.patientId == i) {
                System.out.println(patient);
                return;
            }
        }
        System.out.println("Patient not found");
    }
    //Doctor Details

    // this will add new doctor;
    static void addNewDoctor() {
        Doctor doctor = new Doctor();
        doctor.input();
        doctorList.add(doctor);
    }

    // this will print all doctors
    void printAllDoctors() {
        for (Doctor doctor : doctorList) {
            System.out.println(doctor);
        }
    }

    static void searchDoctorById() {
        System.out.println("Enter Doctor ID");
        int id = inputNumber();
        for (Doctor doctor : doctorList) {
            if (doctor.doctorId == id) {
                System.out.println(doctor);
                return;
            }
        }
        System.out.println("No doctor found");
    }


    // this will search doctor on specialization
    static void searchDoctorsOnSpecialization() {
        System.out.println("Enter Specialization");
        String s = inputString();
        for (Doctor doctor : doctorList) {
            if (doctor.doctorSpecialization.contains(s)) {
                System.out.println(doctor);
                return;
            }
        }
    }

    // search patient on id
    static Patient getPatientOnId(int id) {
        for (Patient patient : patientList) {
            if (patient.patientId == id)
                return patient;
        }
        return null;
    }

    static Patient getPatientOnPhoneNumber(String phoneNumber) {
        for (Patient patient : patientList) {
            if (patient.patientPhoneNumber.equalsIgnoreCase(phoneNumber))
                return patient;
        }
        return null;
    }

    //search doctor on id
    static Doctor getDoctorOnId(int id) {
        for (Doctor doctor : doctorList) {
            if (doctor.doctorId == id) {
                return doctor;
            }
        }
        return null;
    }

    //print all record with patents phoneNumber

    static void printPatientRecordsByPhoneNumber() {
        System.out.println("Enter Phone Number");
        String phoneNumber = inputString();
        Patient patient = getPatientOnPhoneNumber(phoneNumber);
        if (patient == null) {
            System.out.println("No patient exist with given phone Number");
            return;
        }
        for (Consultations consultations : consultationsList) {
            if (consultations.patientRegistrationNumber == patient.patientId)
                System.out.println(consultations);
        }
    }

    static void updatePatientById() {
        System.out.println("Enter Patient ID");
        int i = inputNumber();
        for (Patient patient : patientList) {
            if (patient.patientId == i) {
                patient.input();
                return;
            }
        }
        System.out.println("Patient not found");
    }
    //this will remove doctor from the list

    static void removeDoctorOnId() {
        System.out.println("Enter Patient ID");
        int i = inputNumber();
        for (Doctor doctor : doctorList) {
            if (doctor.doctorId == i) {
                doctorList.remove(doctor);
                return;
            }
        }
        System.out.println("No doctor Found");
    }

    static void addLabTest() {
        System.out.println("Enter Patient ID");
        int i = inputNumber();
        Patient patient = getPatientOnId(i);
        if (patient == null) {
            System.out.println("No patient exist");
            return;
        }
        System.out.println("Enter Doctor Id");
        i = inputNumber();
        Doctor doctor = getDoctorOnId(i);
        if (doctor == null) {
            System.out.println("Doctor don't exist");
        }
        System.out.println("Enter Report");
        String report = inputString();
        LabTest labTest = new LabTest(report, doctor, patient);
        labTests.add(labTest);
    }


    static void searchLabTestOnPatientId() {
        System.out.println("Enter Patient ID");
        int i = inputNumber();
        for (LabTest labTest : labTests) {
            if (labTest.getPatient().patientId == i) {
                System.out.println(labTest);
                return;
            }
        }
    }

    void displayAllAppointments() {
        for (Consultations consultations : consultationsList) {
            System.out.println(consultations);
        }
    }

    static void displayAppointmentOnDoctor() {
        System.out.println("Enter Doctor ID");
        int i = inputNumber();
        Doctor doctor = getDoctorOnId(i);
        if (doctor == null) {
            System.out.println("Doctor don't exist");
            return;
        }
        for (Consultations consultations : consultationsList) {
            if (consultations.getDoctorId() == doctor.doctorId)
                System.out.println(consultations);
        }


    }

    static void addAppointment() {
        System.out.println("Enter Patient ID");
        int i = inputNumber();
        Patient patient = getPatientOnId(i);
        if (patient == null) {
            System.out.println("Patient don't exist");
            return;
        }
        System.out.println("Enter Doctor ID");
        i = inputNumber();
        Doctor doctor = getDoctorOnId(i);
        if (doctor == null) {
            System.out.println("Doctor don't exist");
            return;
        }
        Consultations consultations = new Consultations();
        consultations.setDoctorId(doctor.getDoctorId());
        consultations.setPatientRegistrationNumber(patient.getPatientId());
        consultations.input();
        consultationsList.add(consultations);
    }

    static void printReport() {
        System.out.println("Enter Date : ");
        String date = inputString();
        boolean res = false;
        for (Consultations consultations : consultationsList) {
            if (date.equalsIgnoreCase(consultations.getDate())) {
                res = true;
                Patient patient = getPatientOnId(consultations.getPatientRegistrationNumber());
                Doctor doctor = getDoctorOnId(consultations.getDoctorId());
                System.out.println("-------------------------------");
                System.out.println(patient);
                System.out.println(doctor);
                System.out.println(consultations);
                System.out.println("-------------------------------");
            }
        }
        if (!res)
            System.out.println("No Appointments ON particular date");
    }

    static void Launch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the option");
        String option = "";
        while (!option.equalsIgnoreCase("Exit")) {
            System.out.println("PN -> add new patient");
            System.out.println("PI -> search Patient By Id");
            System.out.println("PA ->print All Patients");
            System.out.println("DN -> add New Doctor");
            System.out.println("DI -> search Doctor By Id");
            System.out.println("DA -> print all Doctors");
            System.out.println("PRP -> print Patient Records By PhoneNumber");
            System.out.println("PU -> update Patient By Id");
            System.out.println("DS -> search Doctors On Specialization");
            System.out.println("DR -> remove Doctor On Id");
            System.out.println("LTA -> add Lab Test");
            System.out.println("LTS -> search Lab Test On Patient Id");
            System.out.println("AA -> add Appointment");
            System.out.println("ADDA -> display Appointment On Doctor");
            System.out.println("ADD -> display Appointment On Date");
            System.out.println("EXIT -> TO EXIT");
            option = scanner.nextLine();
            if (option.equalsIgnoreCase("")) {

            } else if (option.equalsIgnoreCase("PN")) {
                addNewPatient();
            } else if (option.equalsIgnoreCase("PI")) {
                searchPatientById();
            } else if (option.equalsIgnoreCase("PA")) {
                printAllPatients();
            } else if (option.equalsIgnoreCase("DN")) {
                addNewDoctor();
            } else if (option.equalsIgnoreCase("DI")) {
                searchDoctorById();
            } else if (option.equalsIgnoreCase("PRP")) {
                printPatientRecordsByPhoneNumber();
            } else if (option.equalsIgnoreCase("PU")) {
                updatePatientById();
            } else if (option.equalsIgnoreCase("DS")) {
                searchDoctorsOnSpecialization();
            } else if (option.equalsIgnoreCase("DR")) {
                removeDoctorOnId();
            } else if (option.equalsIgnoreCase("LTA")) {
                addLabTest();
            } else if (option.equalsIgnoreCase("LTS")) {
                searchLabTestOnPatientId();
            } else if (option.equalsIgnoreCase("AA")) {
                addAppointment();
            } else if (option.equalsIgnoreCase("ADDA")) {
                displayAppointmentOnDoctor();
            } else if (option.equalsIgnoreCase("ADD")) {
                printReport();
            } else {
                System.out.println("Invalid Input");
            }

        }


    }

}





