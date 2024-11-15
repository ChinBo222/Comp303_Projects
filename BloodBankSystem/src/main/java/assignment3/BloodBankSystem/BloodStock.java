package assignment3.BloodBankSystem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blood_stocks")
public class BloodStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "best_before")
    private Date bestBefore;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "blood_bank_id")
    private BloodBank bloodBank;

    // Getters and setters
}
