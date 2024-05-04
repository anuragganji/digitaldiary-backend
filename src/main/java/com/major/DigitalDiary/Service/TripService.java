package com.major.DigitalDiary.Service;

import com.major.DigitalDiary.Model.Trip;
import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final UserService userService;

    public TripService(TripRepository tripRepository, UserService userService) {
        this.tripRepository = tripRepository;
        this.userService = userService;
    }

    public List<Trip> findAllTrips(String username) {
        User user = userService.findUserByUsername(username);
        return tripRepository.findAllTripsByUsername(user);
    }
}
