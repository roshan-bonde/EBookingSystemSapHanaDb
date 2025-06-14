package com.roshan.EBookingSystem.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Booking {

    // Unique ID for each booking
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)    
    private Integer bookingId;

    // User ID of the person who made the booking
    private Integer userId;
    private String email;

    // Vehicle ID of the booked vehicle
    private Integer vehicleId;
    private String vehicleType;

    // Date of booking
    private String bookingDate;

    // Date of journey
    private String dateOfJourney;

    private String fromCity;

    private String toCity;

    // Total amount paid for the booking
    private Double totalAmount;

    // Status of the booking (e.g., confirmed, cancelled)
    private String status;

    // Number of seats booked
    private Integer numberOfSeatsBooked;

    // Payment method used (e.g., credit card, debit card, etc.)
    private String paymentMethod;
}
