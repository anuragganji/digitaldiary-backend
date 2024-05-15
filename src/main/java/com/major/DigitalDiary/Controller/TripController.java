package com.major.DigitalDiary.Controller;


import com.major.DigitalDiary.DTO.TripUsers;
import com.major.DigitalDiary.Model.UserTripRelation;
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
    public ResponseEntity<List<UserTripRelation>> getAllUsers(@PathVariable("username") String username) {
        List<UserTripRelation> trips = tripService.findAllTrips(username);
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Void> createPost(@RequestBody TripUsers tripUsers) {

        System.out.println("Trip Users: " + tripUsers);

        //throw new RuntimeException("Contact Support!!");
        tripService.createTrip(tripUsers);
        return ResponseEntity.ok().build();
    }
}
