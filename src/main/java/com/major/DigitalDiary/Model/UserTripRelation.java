package com.major.DigitalDiary.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_trip_relations")
public class UserTripRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripRelationId;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;


    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip tripId;

    public Long getTripRelationId() {
        return tripRelationId;
    }

    public void setTripRelationId(Long tripRelationId) {
        this.tripRelationId = tripRelationId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Trip getTripId() {
        return tripId;
    }

    public void setTripId(Trip tripId) {
        this.tripId = tripId;
    }

    @Override
    public String toString() {
        return "UserTripRelation{" +
                "tripRelationId=" + tripRelationId +
                ", userId=" + userId +
                ", tripId=" + tripId +
                '}';
    }
}

