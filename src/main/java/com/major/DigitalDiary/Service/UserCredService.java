package com.major.DigitalDiary.Service;

import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Model.UserCreds;
import com.major.DigitalDiary.Repository.UserCredRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCredService {


    private final UserCredRepository userCredRepository;

    private final UserService userService;

    public UserCredService(UserCredRepository userCredRepository, UserService userService) {
        this.userCredRepository = userCredRepository;
        this.userService = userService;
    }


    public UserCreds findUserCredsByUsername(String username) {
        System.out.println(username);
        User user = userService.findUserByUsername(username);
        System.out.println(user);
        UserCreds userCreds = userCredRepository.findUserCredsByUser(user);
        System.out.println(userCreds);
        return userCreds;
    }

    public UserCreds addUserCreds(UserCreds userCreds) {
        return userCredRepository.save(userCreds);
    }
}
