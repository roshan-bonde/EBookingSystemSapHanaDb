package com.roshan.EBookingSystem.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "type")
public abstract class Vehicle {

    @Id
    // Unique ID for each vehicle
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)    
    private Integer id;

    // Type of vehicle (e.g., bus, train, etc.)
    // private String type;
    private String fromCity;
    private String toCity;
    private LocalDate dateOfJourney;
    private Double price;
    private String departureTime;
    private String arrivalTime;
    private String midStations; // Comma seprated list
}
