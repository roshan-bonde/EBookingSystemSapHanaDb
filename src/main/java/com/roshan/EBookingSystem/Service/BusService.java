package com.roshan.EBookingSystem.Service;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roshan.EBookingSystem.Repository.BusRepo;
import com.roshan.EBookingSystem.Repository.VehicleRepo;
import com.roshan.EBookingSystem.Entity.Bus;

@Service
public class BusService implements VehicleService<Bus> {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired BusRepo busRepo;

    @Override
    public ArrayList<Bus> search(String from, String to, LocalDate dateOfJourmey) {
        return vehicleRepo.findByFromCityAndToCityAndDateOfJourney(from, to, dateOfJourmey).stream()
                .filter(vehicle -> vehicle instanceof Bus)
                .map(vehicle -> (Bus) vehicle)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Optional<Bus> getDetails(String id) {
        return vehicleRepo.findById(id).filter(vehicle -> vehicle instanceof Bus).map(vehicle -> (Bus)vehicle);
    }

    @Override
    public Bus add(Bus bus) {
        return busRepo.save(bus); 
    }

    @Override
    public List<Bus> getAll() {
        return busRepo.findAll().stream()
                .filter(vehicle -> vehicle instanceof Bus)
                .map(vehicle -> (Bus) vehicle)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}