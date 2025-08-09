public class AdmissionRecord {
    private Patient patient;
    private Doctor doctor;
    private Ward ward;

    // Constructor
    public AdmissionRecord(Patient patient, Doctor doctor, Ward ward) {
        this.patient = patient;
        this.doctor = doctor;
        this.ward = ward;
    }

    // Getters
    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Ward getWard() {
        return ward;
    }

    // Setters
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }
}
