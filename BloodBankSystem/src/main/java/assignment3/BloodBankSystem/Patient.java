package assignment3.BloodBankSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    // Getters and setters
}
