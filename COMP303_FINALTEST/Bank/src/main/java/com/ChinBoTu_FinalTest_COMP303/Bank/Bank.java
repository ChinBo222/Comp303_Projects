package com.ChinBoTu_FinalTest_COMP303.Bank;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "Bank")
public class Bank {

    @Id
    //mongo ID
    private String _id;
    //custom id
    private String bankID;

    @NotBlank(message = "Bank name required")
    private String bankName;

    @Min(value = 1800, message = "enter a year after 1800")
    private int bankYear;

    @Min(value = 1, message = "Number of employees must be at least 1")
    private int bankEmp;

    @NotBlank(message = "Address is required")
    private String bankAddress;

    @Min(value = 1, message = "Number of branches must be at least 1")
    private int bankBranches;

    @Min(value = 1, message = "Number of ATMs must be at least 1")
    private int bankATMs;

    // Getters and Setters
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankYear() {
        return bankYear;
    }

    public void setBankYear(int bankYear) {
        this.bankYear = bankYear;
    }

    public int getBankEmp() {
        return bankEmp;
    }

    public void setBankEmp(int bankEmp) {
        this.bankEmp = bankEmp;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public int getBankBranches() {
        return bankBranches;
    }

    public void setBankBranches(int bankBranches) {
        this.bankBranches = bankBranches;
    }

    public int getBankATMs() {
        return bankATMs;
    }

    public void setBankATMs(int bankATMs) {
        this.bankATMs = bankATMs;
    }
}