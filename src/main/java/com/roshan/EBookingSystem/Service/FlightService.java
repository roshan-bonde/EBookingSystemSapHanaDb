package com.roshan.EBookingSystem.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roshan.EBookingSystem.Repository.FlightRepo;
import com.roshan.EBookingSystem.Repository.VehicleRepo;
import com.roshan.EBookingSystem.Entity.Flight;

@Service
public class FlightService implements VehicleService<Flight> {

    @Autowired
    private VehicleRepo vehicleRepo;
    @Autowired
    private FlightRepo flightRepo;

    @Override
    public List<Flight> search(String from, String to, LocalDate dateOfJourmey) {
        return vehicleRepo.findByFromCityAndToCityAndDateOfJourney(from, to, dateOfJourmey).stream()
                .filter(vehicle -> vehicle instanceof Flight)
                .map(vehicle -> (Flight) vehicle)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Optional<Flight> getDetails(String id) {
        return vehicleRepo.findById(id).filter(vehicle -> vehicle instanceof Flight).map(vehicle -> (Flight) vehicle);
    }

    @Override
    public Flight add(Flight flight) {
         return flightRepo.save(flight);
    }

    @Override
    public List<Flight> getAll() {
        return flightRepo.findAll().stream()
                .filter(vehicle -> vehicle instanceof Flight)
                .map(vehicle -> (Flight) vehicle)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
