package com.roshan.EBookingSystem.Dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FlightAddRequestBody {

    // Type of vehicle (e.g., bus, train, etc.)
    // private String type;
    private String fromCity;
    private String toCity;
    private LocalDate dateOfJourney;
    private Double price;
    private String departureTime;
    private String arrivalTime;
    private String midStations; // Comma seprated list

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
