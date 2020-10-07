public class LabTest extends Hospital {
    String labTestReport;
    Doctor refereedDoctor;
    Patient patient;

    public LabTest(String labTestReport, Doctor refereedDoctor, Patient patient) {
        this.labTestReport = labTestReport;
        this.refereedDoctor = refereedDoctor;
        this.patient = patient;
    }

    public String getLabTestReport() {
        return labTestReport;
    }

    public void setLabTestReport(String labTestReport) {
        this.labTestReport = labTestReport;
    }

    public Doctor getRefereedDoctor() {
        return refereedDoctor;
    }

    public void setRefereedDoctor(Doctor refereedDoctor) {
        this.refereedDoctor = refereedDoctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "LabTest{" +
                "\nlabTestReport='" + labTestReport + '\'' +
                "\nrefereedDoctor=" + refereedDoctor +
                "\npatient=" + patient +
                '}';
    }
}
