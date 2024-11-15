package assignment3.BloodBankSystem;

public class BloodBank{
    //List of private fields for BloodBank:
    private Long id;
    private String bloodbankName;
    private String address;
    private String city;
    private String phone;
    private String email;

    //Getters and Setters:
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getBloodbankName() {
        return bloodbankName;
    }
    public void setBloodbankName(String bloodbankName) {
        this.bloodbankName = bloodbankName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    //Constructor for BloodBank:
    public BloodBank(Long id, String bloodbankName, String address, String City, String Phone, String Email){
        this.id = id;
        this.bloodbankName = bloodbankName;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

}