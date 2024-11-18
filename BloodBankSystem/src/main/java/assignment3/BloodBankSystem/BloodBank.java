package assignment3.BloodBankSystem;


public class BloodBank {
    //Private fields for BloodBank
    private Long id;
    private String bloodBankName;
    private String address;
    private String city;
    private String phone;
    private String email;

    // Getters and Setters for BloodBank so data can be accessed:

    //ID
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //Bloodbank Name
    public String getBloodBankName() {
        return bloodBankName;
    }
    public void setBloodBankName(String bloodBankName) {
        this.bloodBankName = bloodBankName;
    }

    //Address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    //City
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    //phone Number
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    //Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}