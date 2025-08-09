import java.util.List;
import java.util.ArrayList;

public class HospitalSystem {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Ward> wards;
    private List<AdmissionRecord> admissionRecords;
    private List<TreatedRecord> treatedRecords;
    private List<DischargedRecord> dischargedRecords;

    // Constructor to initialize the HospitalSystem with empty collections
    public HospitalSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.wards = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        String id = "P" + (patients.size() + 1); // P1, P2, ...
        patient.setPatientID(id);
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        String id = "D" + (doctors.size() + 1); // D1, D2, ...
        doctor.setDoctorID(id);
        doctors.add(doctor);
    }

    public void addWard(Ward ward) {
        String id = "W" + (wards.size() + 1); // W1, W2, ...
        ward.setWardID(id);
        wards.add(ward);
    }


    public void addAdmissionRecord(AdmissionRecord ar) {
        admissionRecords.add(ar);
    }

    public void addTreatedRecord(TreatedRecord tr) {
        treatedRecords.add(tr);
    }

    public void addDischargedRecord(DischargedRecord dr) {
        dischargedRecords.add(dr);
    }

    // Method to retrieve information about all patients
    public List<Patient> getAllPatients() {
        return patients;
    }

    // Method to retrieve information about all doctors
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Method to retrieve information about all wards
    public List<Ward> getAllWards() {
        return wards;
    }

    public List<AdmissionRecord> getAdmissionRecords () {
        return admissionRecords;
    }

    public List<TreatedRecord> getTreatedRecords () {
        return treatedRecords;
    }

    public List<DischargedRecord> getDischargedRecords () {
        return dischargedRecords;
    }

    public Patient getPatientByID(int id) {
        if (id > 0 && id <= patients.size()) {
            return patients.get(id - 1);
        }
        return null;
    }

    public Doctor getDoctorByID(int id) {
        if (id > 0 && id <= doctors.size()) {
            return doctors.get(id - 1);
        }
        return null;
    }

    public Ward getWardByID(int id) {
        if (id > 0 && id <= wards.size()) {
            return wards.get(id - 1);
        }
        return null;
    }

}
