package assignment3.BloodBankSystem;


import java.util.Date;

import java.time.LocalDate;

public class BloodStock {
    //Private fields for Blood Stock
    private Long id;
    private String bloodGroup;
    private int quantity;
    private LocalDate bestBefore;
    private String status;

    // Getters and Setters for Blood Stock
    //Id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //blood group
    public String getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    //Quantity
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //best before date
    public LocalDate getBestBefore() {
        return bestBefore;
    }
    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    //status
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
