import java.util.List;

public interface HIH {

    // Initialize the hospital system with a given number of patients, doctors, and wards.
    public HospitalSystem InitializeHospitalSystem(int numOfPatients, int numOfWards, int numOfDoctors);

    // Admit a patient into the hospital system, assign them a doctor and a ward.
    public AdmissionRecord Admit(Patient p, Ward w, Doctor d);

    // Treat the patient based on their admission record, and update the record with treatment information.
    public TreatedRecord Treat(AdmissionRecord ar, TreatmentPlan tp);

    // Discharge the patient based on their treated record, and finalize the discharge details.
    public DischargedRecord Discharge(TreatedRecord tr, DischargeSummary ds, BillingDetails bd);
}
