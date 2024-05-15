package com.major.DigitalDiary.Service;

import com.major.DigitalDiary.DTO.TripUsers;
import com.major.DigitalDiary.Model.Trip;
import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Model.UserTripRelation;
import com.major.DigitalDiary.Repository.TripRepository;
import com.major.DigitalDiary.Repository.UserTripRelationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final UserService userService;
    private final UserTripRelationRepository userTripRelationRepository;

    public TripService(TripRepository tripRepository, UserService userService, UserTripRelationRepository userTripRelationRepository) {
        this.tripRepository = tripRepository;
        this.userService = userService;
        this.userTripRelationRepository = userTripRelationRepository;
    }

    public Trip findTripById(Long tripId) {
        return tripRepository.findById(tripId).orElse(null);
    }

    public void createTrip(TripUsers tripDetails) {
        Trip newTrip = new Trip();
        newTrip.setTripName(tripDetails.getTripName());

        newTrip = tripRepository.save(newTrip);

        for (String username : tripDetails.getUsernames()) {
            User user = userService.findUserByUsername(username);

            UserTripRelation newTripRelation = new UserTripRelation();

            newTripRelation.setTripId(newTrip);
            newTripRelation.setUserId(user);

            userTripRelationRepository.save(newTripRelation);
        }
    }

    public List<UserTripRelation> findAllTrips(String username) {
        User user = userService.findUserByUsername(username);

        System.out.println(user);
        return userTripRelationRepository.findAllByUserId(user);
    }

}
