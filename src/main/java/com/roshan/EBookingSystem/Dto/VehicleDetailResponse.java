package com.roshan.EBookingSystem.Dto;

import java.time.LocalDate;
import java.util.Map;

import lombok.Data;

@Data
public class VehicleDetailResponse {

    private String fromCity;
    private String toCity;
    private String travelClass;
    private LocalDate dateOfJourney;

    private double fare;
    private String departureTime;
    private String arrivalTime;
    private String midStations;

    private Map<String, String> additionalInfo;
}
