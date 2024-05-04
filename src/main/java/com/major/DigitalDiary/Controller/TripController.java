package com.major.DigitalDiary.Controller;


import com.major.DigitalDiary.Model.Trip;
import com.major.DigitalDiary.Service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "${frontend.origin}")
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/all/{username}")
    public ResponseEntity<List<Trip>> getAllUsers(@PathVariable("username") String username) {
        List<Trip> trips = tripService.findAllTrips(username);
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }
}
