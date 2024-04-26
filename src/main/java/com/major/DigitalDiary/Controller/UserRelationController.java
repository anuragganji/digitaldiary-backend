package com.major.DigitalDiary.Controller;

import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Model.UserRelation;
import com.major.DigitalDiary.Service.UserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${frontend.origin}")
@RequestMapping("/parent")
public class UserRelationController {

    @Autowired
    UserRelationService userRelationService;

    @PostMapping(path = "/set/{username}")
    public ResponseEntity<Void> setParent(@PathVariable String username, @RequestBody User user){
        System.out.println("User Details");
        System.out.println(user);
        //throw new RuntimeException("Contact Support!!");
        userRelationService.setUserRelation(username,user);
        return ResponseEntity.ok().build();
    }
}
