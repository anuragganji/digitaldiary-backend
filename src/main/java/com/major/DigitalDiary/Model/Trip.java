package com.major.DigitalDiary.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    private String tripName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId=" + tripId +
                ", tripName='" + tripName + '\'' +
                ", userId=" + userId +
                '}';
    }
}