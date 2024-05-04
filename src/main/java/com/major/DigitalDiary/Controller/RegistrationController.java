package com.major.DigitalDiary.Controller;


import com.major.DigitalDiary.DTO.Registration;
import com.major.DigitalDiary.Exception.UserNotAvailableException;
import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Model.UserCreds;
import com.major.DigitalDiary.Service.RegistrationService;
import com.major.DigitalDiary.Service.UserCredService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${frontend.origin}")
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final UserCredService userCredService;

    public RegistrationController(RegistrationService registrationService, UserCredService userCredService) {
        this.registrationService = registrationService;
        this.userCredService = userCredService;
    }

    @PostMapping("")
    public ResponseEntity<User> addUser(@RequestBody Registration userDetails) {
        try {

            User user = new User();
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());


            User newUser = registrationService.addUser(user);

            UserCreds userCreds = new UserCreds();
            userCreds.setPassword(userDetails.getPassword());
            userCreds.setUser(newUser);
            UserCreds newUserCreds = userCredService.addUserCreds(userCreds);
            System.out.println(userCreds);

            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (UserNotAvailableException e) {
            return new ResponseEntity<>(null, e.getStatusCode());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
