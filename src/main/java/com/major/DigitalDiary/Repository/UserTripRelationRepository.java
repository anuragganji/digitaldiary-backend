package com.major.DigitalDiary.Repository;

import com.major.DigitalDiary.Model.Trip;
import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Model.UserTripRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTripRelationRepository extends JpaRepository<UserTripRelation, Long> {
    public List<UserTripRelation> findAllByUserId(User user);

    public List<UserTripRelation> findAllByTripIdAndUserId(Trip tripId, User userId);
}
