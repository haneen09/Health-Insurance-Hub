import java.util.List;
import java.util.ArrayList;

public class TreatmentPlan {
    private List<Medication> medications;
    private List<String> procedures;  // Use List for multiple procedures
    private String doctorNotes;
    private int recoveryDays;

    public TreatmentPlan(List<Medication> medications, List<String> procedures, String doctorNotes) {
        this.medications = medications;
        this.procedures = procedures;
        this.doctorNotes = doctorNotes;

    }
    public TreatmentPlan(){
        this.medications = new ArrayList<Medication>();
        this.procedures = new ArrayList<String>();
        this.doctorNotes = "N/A";
        this.recoveryDays = calculateRecoveryDays();
    }

    // Getters
    public List<Medication> getMedications() {
        return medications;
    }

    public List<String> getProcedures() {
        return procedures;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public int getRecoveryDays() {
        return recoveryDays;
    }

    // Setters
    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public void setProcedures(List<String> procedures) {
        this.procedures = procedures;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    public void setRecoveryDays(int recoveryDays) {
        this.recoveryDays = recoveryDays;
    }

    public int calculateRecoveryDays() {
        if (medications.isEmpty()) return 14;

        double effect = 0;

        for (Medication med : medications) {
            effect += med.getDosage() * med.getFrequency(); // stronger meds = faster recovery
        }

        int recoveryDays = (int) Math.max(1, 14 - (effect / 100)); // effect scale: 100 dosage*freq reduces 1 day
        return recoveryDays;
    }
    public void updateRecoveryDays() {
        recoveryDays = calculateRecoveryDays();
    }



    @Override
    public String toString() {
        return
                "Treatment plan medications:" + medications + "\n"+
                "Treatment plan procedures:" + procedures +"\n"+
                "Treatment plan doctor notes:" + doctorNotes + "\n"+
                "Treatment plan recovery days:" + recoveryDays +"\n";
    }

}
