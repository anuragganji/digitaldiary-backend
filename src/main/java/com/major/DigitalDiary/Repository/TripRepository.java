package com.major.DigitalDiary.Repository;

import com.major.DigitalDiary.Model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
