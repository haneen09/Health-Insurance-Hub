public class BillingDetails {
    private double treatmentCost;  // Total cost of treatment
    private double insuranceCoverage;  // The amount covered by insurance
    private double outstandingBalance;  // The amount still owed by the patient
    private String paymentMethod;  // The payment method used (e.g., credit card, insurance, cash)
    private boolean paymentStatus;  // Whether the payment has been completed or not

    // Constructor
    public BillingDetails(double treatmentCost, double insuranceCoverage, double outstandingBalance,
                          String paymentMethod, boolean paymentStatus) {
        this.treatmentCost = treatmentCost;
        this.insuranceCoverage = insuranceCoverage;
        this.outstandingBalance = outstandingBalance;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    // Getter and Setter for treatmentCost
    public double getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost(double treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    // Getter and Setter for insuranceCoverage
    public double getInsuranceCoverage() {
        return insuranceCoverage;
    }

    public void setInsuranceCoverage(double insuranceCoverage) {
        this.insuranceCoverage = insuranceCoverage;
    }

    // Getter and Setter for outstandingBalance
    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(double outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    // Getter and Setter for paymentMethod
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Getter and Setter for paymentStatus
    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Method to calculate outstanding balance after applying payments
    public void calculateOutstandingBalance() {
        this.outstandingBalance = treatmentCost - insuranceCoverage;
    }



    @Override
    public String toString() {
        return "BillingDetails{" +
                "treatmentCost=" + treatmentCost +
                ", insuranceCoverage=" + insuranceCoverage +
                ", outstandingBalance=" + outstandingBalance +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
