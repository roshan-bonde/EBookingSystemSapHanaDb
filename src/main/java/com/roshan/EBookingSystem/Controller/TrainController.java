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

import com.roshan.EBookingSystem.Dto.TrainAddRequestBody;
import com.roshan.EBookingSystem.Entity.Train;
import com.roshan.EBookingSystem.Entity.Vehicle;
import com.roshan.EBookingSystem.Service.TrainService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    TrainService trainService;

    @GetMapping("search")
    public List<Train> search(@RequestParam String from, @RequestParam String to,
            @RequestParam String dateOfJourmey) throws ParseException {
        LocalDate doj = LocalDate.parse(dateOfJourmey);
        return trainService.search(from, to, doj);
    }

    @GetMapping("all")
    public List<Train> getAllTrains() {
        List<Train> trains = trainService.getAll();
        return trains;
    }

    @GetMapping("{id}")
    public ResponseEntity<? extends Vehicle> getDaeatils(@PathVariable String id) {
        return trainService.getDetails(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("add")
    public ResponseEntity<Train> addTrain(@RequestBody TrainAddRequestBody trainAddRequestBody) {

        Train newTrain = new Train();
        newTrain.setFromCity(trainAddRequestBody.getFromCity());
        newTrain.setToCity(trainAddRequestBody.getToCity());
        newTrain.setMidStations(trainAddRequestBody.getMidStations());
        newTrain.setArrivalTime(trainAddRequestBody.getArrivalTime());
        newTrain.setDepartureTime(trainAddRequestBody.getDepartureTime());
        newTrain.setPrice(trainAddRequestBody.getPrice());
        newTrain.setDateOfJourney(trainAddRequestBody.getDateOfJourney());
        newTrain.setTrainNumber(trainAddRequestBody.getTrainNumber());
        newTrain.setTrainName(trainAddRequestBody.getTrainName());
        newTrain.setTrainSpeed(trainAddRequestBody.getTrainSpeed());
        newTrain.setTrainType(trainAddRequestBody.getTrainType());
        newTrain.setNumberOfCoaches(trainAddRequestBody.getNumberOfCoaches());
        newTrain.setOperatorName(trainAddRequestBody.getOperatorName());

        Train savedTrain = trainService.add(newTrain);
        return ResponseEntity.ok(savedTrain);
    }
}
