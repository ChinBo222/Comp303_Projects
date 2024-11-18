package assignment3.BloodBankSystem;

public class Patient {
    //Private Fields for Patient
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String bloodGroup;
    private String city;
    private String phone;

    // Getters and Setters for Patient

    //id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
}