package com.major.DigitalDiary.Service;

import com.major.DigitalDiary.Exception.UserNotAvailableException;
import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserRepository userRepository;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        User oldUser = userRepository.findUserByUsername(user.getUsername());
        if (oldUser != null) {
            throw new UserNotAvailableException("User already exists");
        } else {
            return userRepository.save(user);
        }
    }

}
