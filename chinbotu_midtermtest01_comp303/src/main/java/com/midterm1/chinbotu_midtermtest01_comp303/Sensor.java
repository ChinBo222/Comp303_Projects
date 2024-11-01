package com.midterm1.chinbotu_midtermtest01_comp303;
//Task 1 and 2: sensorDB creation

//import dependency classes
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
//the table name in the database is called Sensor Table
@Table(name = "Sensor")
public class Sensor {

    //sets the id for each sensor
    //id specifies that sensorID is the primary Key
    @Id
    //generatedValue makes it so that the id is automatically generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //creates a int for sensorID
    private int sensorID;

    //validator to make sure that sensorName field is not blank
    @NotBlank(message = "Name Required")
    //declares sensorName field
    private String sensorName;

    //validator for sensorType to not be blank
    @NotBlank(message = "SensorType required")
    //declare sensorType as field
    private String sensorType;

    //validator for pin - need to be required
    @NotNull(message = "Pin required")
    //valitor to set a min and max int value
    @Min(value = 0, message = "Sensor Pin must be 0 - 1000")
    @Max(value = 1000, message = "Sensor Pin must be 0 - 1000")
    //declares integer sensorPin
    private Integer sensorPin;

    //declares optional sensorLocation - no validator needed
    private String sensorLocation;

    //validator for status
    @NotNull(message = "Sensor Status required")
    //validator that sets a pattern that matches a expression, on OR off
    @Pattern(regexp = "ON|OFF", message = "Status must be either ON or OFF")
    //declares status field
    private String sensorStatus;

    // Getters and Setters so that field data can be accessible
    public int getSensorID() {
        return sensorID;
    }
    public void setSensorID(int sensorID) {
        this.sensorID = sensorID;
    }
    public String getSensorName() {
        return sensorName;
    }
    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
    public String getSensorType() {
        return sensorType;
    }
    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }
    public Integer getSensorPin() {
        return sensorPin;
    }
    public void setSensorPin(Integer sensorPin) {
        this.sensorPin = sensorPin;
    }
    public String getSensorLocation() {
        return sensorLocation;
    }
    public void setSensorLocation(String sensorLocation) {
        this.sensorLocation = sensorLocation;
    }
    public String getSensorStatus() {
        return sensorStatus;
    }
    public void setSensorStatus(String sensorStatus) {
        this.sensorStatus = sensorStatus;
    }
}
