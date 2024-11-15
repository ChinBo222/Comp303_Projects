package assignment3.BloodBankSystem;
//Import dependencies:
import java.util.Date;

public class BloodStock{
    //List of private fields for BloodStock:
    private Long id;
    private String bloodGroup;
    private int quantity;
    private Date bestBefore;
    private String status;

    //Getters and Setters:
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getBestBefore() {
        return bestBefore;
    }
    public void setBestBefore(Date bestBefore) {
        this.bestBefore = bestBefore;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    //Constructor for BloodStock:
    public BloodStock(Long id, String bloodGroup, int quantity, Date bestBefore, String status){
        this.id = id;
        this.bloodGroup = bloodGroup;
        this.quantity = quantity;
        this.bestBefore = bestBefore;
        this.status = status;
    }
}