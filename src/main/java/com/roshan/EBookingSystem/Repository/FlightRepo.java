package com.roshan.EBookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roshan.EBookingSystem.Entity.Flight;

public interface FlightRepo extends JpaRepository<Flight, String> {

}
