import java.util.List;

/**
 * Represents the final discharge record of a patient, extending TreatedRecord.
 * Contains discharge summary and billing details.
 */
public class DischargedRecord extends TreatedRecord {
    private DischargeSummary dischargeSummary;
    private BillingDetails billingDetails;

    // Constructor
    public DischargedRecord(Patient patient, Doctor doctor, Ward ward, TreatmentPlan treatmentPlan,
                            DischargeSummary dischargeSummary, BillingDetails billingDetails) {
        super(patient, doctor, ward, treatmentPlan);  // Call the constructor of TreatedRecord
        this.dischargeSummary = dischargeSummary;
        this.billingDetails = billingDetails;
    }

    // Getters and setters for dischargeSummary
    public DischargeSummary getDischargeSummary() {
        return dischargeSummary;
    }

    public void setDischargeSummary(DischargeSummary dischargeSummary) {
        this.dischargeSummary = dischargeSummary;
    }

    // Getters and setters for billingDetails
    public BillingDetails getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    // Getters and setters for inherited fields from TreatedRecord
    public Patient getPatient() {
        return super.getPatient();
    }

    public void setPatient(Patient patient) {
        super.setPatient(patient);
    }

    public Doctor getDoctor() {
        return super.getDoctor();
    }

    public void setDoctor(Doctor doctor) {
        super.setDoctor(doctor);
    }

    public Ward getWard() {
        return super.getWard();
    }

    public void setWard(Ward ward) {
        super.setWard(ward);
    }

    public TreatmentPlan getTreatmentPlan() {
        return super.getTreatmentPlan();
    }

    public void setTreatmentPlan(TreatmentPlan treatmentPlan) {
        super.setTreatmentPlan(treatmentPlan);
    }

    public List<Medication> getMedications() {
        return super.getMedications();
    }



    public TreatmentPlan getTreatmentOutcome() {
        return super.getTreatmentPlan();
    }



    @Override
    public String toString() {
        return "DischargedRecord{" +
                "dischargeSummary=" + dischargeSummary +
                ", billingDetails=" + billingDetails +
                ", treatmentPlan=" + getTreatmentPlan() +
                ", medications=" + getMedications() +
                ", treatmentOutcome='" + getTreatmentOutcome() + '\'' +
                ", doctorNotes='" + getTreatmentPlan().getDoctorNotes() + '\'' +
                ", patient=" + getPatient() +
                ", doctor=" + getDoctor() +
                ", ward=" + getWard() +
                '}';
    }
}
