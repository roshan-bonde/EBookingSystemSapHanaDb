package com.roshan.EBookingSystem.Controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roshan.EBookingSystem.Dto.BusAddRequestBody;
import com.roshan.EBookingSystem.Entity.Bus;
import com.roshan.EBookingSystem.Entity.Vehicle;
import com.roshan.EBookingSystem.Service.BusService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/bus")
public class BusController {

    @Autowired
    BusService busService;

    @GetMapping("search")
    public List<Bus> search(@RequestParam String from, @RequestParam String to,
            @RequestParam String dateOfJourmey) throws ParseException {
        LocalDate doj = LocalDate.parse(dateOfJourmey);
        return busService.search(from, to, doj);
    }

    @GetMapping("all")
    public List<Bus> getAllBuses() {
        List<Bus> buses = busService.getAll();
        return buses;
    }

    @GetMapping("{id}")
    public ResponseEntity<? extends Vehicle> getDaeatils(@PathVariable String id) {
        return busService.getDetails(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("add")
    public ResponseEntity<Bus> addBus(@RequestBody BusAddRequestBody busAddRequestBody) {

        if (busAddRequestBody.getBusNumber() == null || busAddRequestBody.getBusNumber().isEmpty()) {
            throw new IllegalArgumentException("Bus number cannot be null or empty");
        }

        Bus newBus = new Bus();
        newBus.setBusNumber(busAddRequestBody.getBusNumber());
        newBus.setFromCity(busAddRequestBody.getFromCity());
        newBus.setToCity(busAddRequestBody.getToCity());
        newBus.setMidStations(busAddRequestBody.getMidStations());
        newBus.setPrice(busAddRequestBody.getPrice());
        newBus.setBusCompanyName(busAddRequestBody.getBusCompanyName());
        newBus.setAmenities(busAddRequestBody.getAmenities());
        newBus.setBusType(busAddRequestBody.getBusType());
        newBus.setDriverDetails(busAddRequestBody.getDriverDetails());
        newBus.setSeatConfiguration(busAddRequestBody.getSeatConfiguration());
        newBus.setTotalSeats(busAddRequestBody.getTotalSeats());
        newBus.setDateOfJourney(busAddRequestBody.getDateOfJourney());
        newBus.setArrivalTime(busAddRequestBody.getArrivalTime());
        newBus.setDepartureTime(busAddRequestBody.getDepartureTime());
        Bus savedBus = busService.add(newBus);

        return ResponseEntity.ok(savedBus);
    }

}
