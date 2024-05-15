package com.major.DigitalDiary.DTO;

import java.util.Arrays;

public class TripUsers {
    private String tripName;
    private String usernames[];

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String[] getUsernames() {
        return usernames;
    }

    public void setUsernames(String[] usernames) {
        this.usernames = usernames;
    }

    @Override
    public String toString() {
        return "TripUsers{" +
                "tripName='" + tripName + '\'' +
                ", usernames=" + Arrays.toString(usernames) +
                '}';
    }
}
