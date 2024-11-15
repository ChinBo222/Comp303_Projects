package assignment3.BloodBankSystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "blood_banks")
public class BloodBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "bloodBank", cascade = CascadeType.ALL)
    private List<BloodStock> bloodStocks;

    // Getters and setters
}
