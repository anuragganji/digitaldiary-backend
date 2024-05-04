package com.major.DigitalDiary.Repository;

import com.major.DigitalDiary.Model.Trip;
import com.major.DigitalDiary.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findAllTripsByUsername(User user);
}
