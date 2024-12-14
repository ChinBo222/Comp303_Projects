package assignment3.BloodBankSystem;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "donor")
public class Donor {
    //Private Fields for Patient
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String bloodGroup;
    private String city;
    private String phone;
    private List<BloodStock> donations;
    private String email;
    private String password;
    // Getters and Setters for Patient

    //id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    //first name
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Last Name
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Age
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //Blood group
    public String getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    //city
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    //phone number
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }


    public List<BloodStock> getDonations() {
        return donations;
    }
    public void setDonations(List<BloodStock> donations) {
        this.donations = donations;
    }

    //login info:
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}