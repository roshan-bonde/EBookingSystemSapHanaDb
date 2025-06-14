package com.roshan.EBookingSystem.Dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TrainAddRequestBody {
    // Type of vehicle (e.g., bus, train, etc.)
    // private String type;
    private String fromCity;
    private String toCity;
    private LocalDate dateOfJourney;
    private Double price;
    private String departureTime;
    private String arrivalTime;
    private String midStations; // Comma seprated list

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
