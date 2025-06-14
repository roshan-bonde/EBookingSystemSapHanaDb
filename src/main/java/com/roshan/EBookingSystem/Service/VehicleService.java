package com.roshan.EBookingSystem.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.roshan.EBookingSystem.Entity.Vehicle;

public interface VehicleService<T extends Vehicle> {

    List<T> search(String from, String to, LocalDate dateOfJourney) ;

    Optional<T> getDetails(String id);

    T add(T t);
    List<T> getAll();
}
