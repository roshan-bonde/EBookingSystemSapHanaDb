package com.roshan.EBookingSystem.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Bus")
public class Bus extends Vehicle {

    // Bus number
    @Column(unique = true, nullable = false)
    private String busNumber;

    // Bus company name
    private String busCompanyName;

    // Bus type (e.g., sleeper, semi-sleeper)
    private String busType;

    // Number of seats in the bus
    private Integer totalSeats;

    // Amenities available in the bus (e.g., Wi-Fi, AC)
    private String amenities;

    // Seat configuration (e.g., 2+2, 2+1)
    private String seatConfiguration;

    // Driver details (name, contact number)
    private String driverDetails;

}
