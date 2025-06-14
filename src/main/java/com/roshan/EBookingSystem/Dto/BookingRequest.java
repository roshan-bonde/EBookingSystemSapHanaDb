package com.roshan.EBookingSystem.Dto;

import lombok.Data;

@Data
public class BookingRequest {

    private Integer userId;
    private String address;
    private String mobileNo;
    private String email;
    private String fromCity;
    private String toCity;
    private String vehicleType;
    private String vehicleId;
    private String dateOfJourney;
    private double amount;
    private Integer noOfSeats;
    private String paymentMethod;
}
