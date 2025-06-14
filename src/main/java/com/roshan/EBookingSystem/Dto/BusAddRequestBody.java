package com.roshan.EBookingSystem.Dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BusAddRequestBody {

    private String fromCity;
    private String toCity;
    private LocalDate dateOfJourney;
    private Double price;
    private String departureTime;
    private String arrivalTime;
    private String midStations; // Comma seprated list

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
