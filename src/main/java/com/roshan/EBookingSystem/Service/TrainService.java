package com.roshan.EBookingSystem.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roshan.EBookingSystem.Entity.Train;
import com.roshan.EBookingSystem.Repository.TrainRepo;
import com.roshan.EBookingSystem.Repository.VehicleRepo;

@Service
public class TrainService implements VehicleService<Train> {

    @Autowired
    private VehicleRepo vehicleRepo;
    @Autowired
    private TrainRepo trainRepo;

    // Implement the methods from VehicleService for Train entity
    @Override
    public List<Train> search(String from, String to, LocalDate dateOfJourney) {
       return vehicleRepo.findByFromCityAndToCityAndDateOfJourney(from, to, dateOfJourney).stream()
                .filter(vehicle -> vehicle instanceof Train)
                .map(vehicle -> (Train) vehicle)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Optional<Train> getDetails(String id) {
        return vehicleRepo.findById(id).filter(vehicle -> vehicle instanceof Train).map(vehicle -> (Train)vehicle);
    }

    @Override
    public Train add(Train train) {
        return trainRepo.save(train);
    }

    @Override
    public List<Train> getAll() {
        return trainRepo.findAll().stream()
                .filter(vehicle -> vehicle instanceof Train)
                .map(vehicle -> (Train) vehicle)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
