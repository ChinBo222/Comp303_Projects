package com.midterm1.chinbotu_midtermtest1_comp303;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sensorID;

    @NotBlank(message = "Sensor Name is mandatory")
    private String sensorName;

    @NotBlank(message = "Sensor Type is mandatory")
    private String sensorType;

    @NotNull(message = "Sensor Pin is mandatory")
    @Min(0)
    @Max(1000)
    private Integer sensorPin;

    private String sensorLocation;

    @NotNull(message = "Sensor Status is mandatory")
    @Pattern(regexp = "ON|OFF", message = "Sensor Status must be either ON or OFF")
    private String sensorStatus;

    // Getters and Setters
    public Long getSensorID() {
        return sensorID;
    }

    public void setSensorID(Long sensorID) {
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
