package com.roshan.EBookingSystem.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Flight")
public class Flight extends Vehicle {

    // Flight number
    @Column(unique = true, nullable = false)
    private String flightNumber;

    // Airline name
    private String airlineName;

    private String flightType; // e.g., domestic, international

    private String flightClass; // e.g., economy, business, first class

    // Flight duration in hours
    private Double flightDuration;

    // Departure terminal
    private String departureTerminal;

    // Arrival terminal
    private String arrivalTerminal;

    // In-flight services (e.g., meals, entertainment)
    private String inFlightServices;

    // Baggage allowance in kg
    private Double baggageAllowance;

    // Seat configuration (e.g., 2-4-2, 3-3-3)
    private String seatConfiguration;

}
