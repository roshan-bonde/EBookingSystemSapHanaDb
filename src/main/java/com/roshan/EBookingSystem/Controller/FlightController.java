package com.roshan.EBookingSystem.Controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roshan.EBookingSystem.Dto.FlightAddRequestBody;
import com.roshan.EBookingSystem.Entity.Flight;
import com.roshan.EBookingSystem.Entity.Vehicle;
import com.roshan.EBookingSystem.Service.FlightService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("search")
    public List<Flight> search(@RequestParam String from, @RequestParam String to,
            @RequestParam String dateOfJourmey) throws ParseException {
        LocalDate doj = LocalDate.parse(dateOfJourmey);
        return flightService.search(from, to, doj);
    }

    @GetMapping("all") 
    public List<Flight> getAllFlights(){
        List<Flight> flights = flightService.getAll();
        return flights;
    }

    @GetMapping("{id}")
    public ResponseEntity<? extends Vehicle> getDaeatils(@PathVariable String id) {
        return flightService.getDetails(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("add")
    public ResponseEntity<Flight> addFlight(@RequestBody FlightAddRequestBody flightAddRequestBody) {

        Flight newFlight = new Flight();
        newFlight.setFromCity(flightAddRequestBody.getFromCity());
        newFlight.setToCity(flightAddRequestBody.getToCity());
        newFlight.setMidStations(flightAddRequestBody.getMidStations());
        newFlight.setDateOfJourney(flightAddRequestBody.getDateOfJourney());
        newFlight.setArrivalTime(flightAddRequestBody.getArrivalTime());
        newFlight.setDepartureTime(flightAddRequestBody.getDepartureTime());
        newFlight.setFlightNumber(flightAddRequestBody.getFlightNumber());
        newFlight.setAirlineName(flightAddRequestBody.getAirlineName());
        newFlight.setFlightType(flightAddRequestBody.getFlightType());
        newFlight.setArrivalTerminal(flightAddRequestBody.getArrivalTerminal());
        newFlight.setDepartureTerminal(flightAddRequestBody.getDepartureTerminal());
        newFlight.setFlightClass(flightAddRequestBody.getFlightClass());
        newFlight.setFlightDuration(flightAddRequestBody.getFlightDuration());
        newFlight.setInFlightServices(flightAddRequestBody.getInFlightServices());
        newFlight.setBaggageAllowance(flightAddRequestBody.getBaggageAllowance());
        newFlight.setSeatConfiguration(flightAddRequestBody.getSeatConfiguration());
        newFlight.setPrice(flightAddRequestBody.getPrice());

        Flight savedFlight = flightService.add(newFlight);
        return ResponseEntity.ok(savedFlight);
    }
}
