public class DischargeSummary {
    private String treatmentSummary;  // Summary of the treatment received
    private String finalDiagnosis;  // Final diagnosis after treatment
    private String followUpInstructions;  // Instructions for follow-up care

    // Constructor
    public DischargeSummary(String treatmentSummary, String finalDiagnosis, String followUpInstructions) {
        this.treatmentSummary = treatmentSummary;
        this.finalDiagnosis = finalDiagnosis;
        this.followUpInstructions = followUpInstructions;
    }

    // Getter and Setter for treatmentSummary
    public String getTreatmentSummary() {
        return treatmentSummary;
    }

    public void setTreatmentSummary(String treatmentSummary) {
        this.treatmentSummary = treatmentSummary;
    }

    // Getter and Setter for finalDiagnosis
    public String getFinalDiagnosis() {
        return finalDiagnosis;
    }

    public void setFinalDiagnosis(String finalDiagnosis) {
        this.finalDiagnosis = finalDiagnosis;
    }

    // Getter and Setter for followUpInstructions
    public String getFollowUpInstructions() {
        return followUpInstructions;
    }

    public void setFollowUpInstructions(String followUpInstructions) {
        this.followUpInstructions = followUpInstructions;
    }

    @Override
    public String toString() {
        return "DischargeSummary{" +
                "treatmentSummary='" + treatmentSummary + '\'' +
                ", finalDiagnosis='" + finalDiagnosis + '\'' +
                ", followUpInstructions='" + followUpInstructions + '\'' +
                '}';
    }
}
