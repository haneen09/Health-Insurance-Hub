public class ContactDetails {
    // Create a constructor to initialize ContactDetails' objects.
    // ContactDetails usually have the following type of information:

    /*
     * • Address
     * • Phone number
     * • Email
     * • Emergency contact
     */

    private String address;
    private String phoneNumber;
    private String email;

    private String emergencyContactNumber;


    public ContactDetails(String address, String phoneNumber, String email, String emergencyContactNumber) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;

        this.emergencyContactNumber = emergencyContactNumber;
    }
    public ContactDetails() {
        this.address = "N/A";
        this.phoneNumber = "N/A";
        this.email = "N/A";

        this.emergencyContactNumber = "N/A";
    }


    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }



    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    @Override
    public String toString() {
        return "Address: " + address + "\nPhone: " + phoneNumber +
                "\nEmail: " + email +
                "\nEmergency Contact: " + emergencyContactNumber;
    }
}

