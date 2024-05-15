package com.major.DigitalDiary.Service;

import com.major.DigitalDiary.Repository.UserTripRelationRepository;
import org.springframework.stereotype.Service;

@Service
public class UserTripRelationService {


    private final UserTripRelationRepository userTripRelationRepository;

    public UserTripRelationService(UserTripRelationRepository userTripRelationRepository) {
        this.userTripRelationRepository = userTripRelationRepository;
    }


}
