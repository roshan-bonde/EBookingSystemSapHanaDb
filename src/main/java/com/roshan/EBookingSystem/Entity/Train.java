package com.roshan.EBookingSystem.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Train")
public class Train extends Vehicle{

    // Train number
    @Column(unique = true, nullable = false)
    private String trainNumber;

    // Train name
    private String trainName;

    // Train type (e.g., express, local)
    private String trainType;

    // Number of coaches
    private Integer numberOfCoaches;

    // Train speed in km/h
    private Double trainSpeed;

    // Train operator name
    private String operatorName;
}
