import java.time.LocalDate;

public class InsuranceDetails {
    // InsuranceDetails usually have the following type of information:
    /*
     * • Insurance provider
     * • Policy number
     * • Coverage type
     * • Expiry date
     */

    private String provider;
    private String policyNumber;
    private String coverageDetails;
    private LocalDate expiryDate;

    public InsuranceDetails(String provider, String policyNumber, String coverageDetails, LocalDate expiryDate) {
        this.provider = provider;
        this.policyNumber = policyNumber;
        this.coverageDetails = coverageDetails;
        this.expiryDate = expiryDate;
    }
    public InsuranceDetails() {
        this.provider = "N/A";
        this.policyNumber = "N/A";
        this.coverageDetails = "N/A";
        this.expiryDate = null;
    }

    public String getProvider() {
        return provider;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getCoverageDetails() {
        return coverageDetails;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setCoverageDetails(String coverageDetails) {
        this.coverageDetails = coverageDetails;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Provider: " + provider +
                "\nPolicyNumber: " + policyNumber +
                "\nCoverageDetails: " + coverageDetails +
                "\nExpiryDate: " + expiryDate;
    }
}
