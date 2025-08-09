import java.util.List;

public class TreatedRecord extends AdmissionRecord {
    private TreatmentPlan treatmentPlan;


    // Constructor
    public TreatedRecord(Patient patient, Doctor doctor, Ward ward, TreatmentPlan treatmentPlan) {
        super(patient, doctor, ward);  // Call the constructor of the superclass (AdmissionRecord)
        this.treatmentPlan = treatmentPlan;
        this.treatmentPlan.calculateRecoveryDays();

    }

    // Getter for treatmentPlan
    public TreatmentPlan getTreatmentPlan() {
        return treatmentPlan;
    }

    // Getter for medications
    public List<Medication> getMedications() {
        return treatmentPlan.getMedications();  // Return the medications list
    }

    // Setter for treatmentPlan
    public void setTreatmentPlan(TreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }



    // Optional: toString method for easy debugging/representation
    @Override
    public String toString() {
        return "TreatedRecord{" +
                "treatmentPlan=" + treatmentPlan +
                ", medications=" + treatmentPlan.getMedications() +
                ", patient=" + getPatient() +
                ", doctor=" + getDoctor() +
                ", ward=" + getWard() +"\n";
    }
}
