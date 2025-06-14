package com.roshan.EBookingSystem.Dto;

import lombok.Data;

@Data
public class VehicleListResponse {

    private String vehicleId;
    private String vehicleType;
    private String busCompanyName;
    private String trainName;
    private String airlineName;
    private double fare;
    private String departureTime;
    private String arrivalTime;

}
