package com.major.DigitalDiary.Controller;

import com.major.DigitalDiary.DTO.ChildEntry;
import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Model.UserRelation;
import com.major.DigitalDiary.Service.UserRelationService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${frontend.origin}")
@RequestMapping("/parentd")
public class ParentalController {

    UserRelationService userRelationService;


    @GetMapping(path = "/{username}")
    public ChildEntry getEntry(@PathVariable String username){
        //throw new RuntimeException("Contact Support!!");
        return new ChildEntry("This is my record from yesterday");
    }

    @PostMapping(path = "/set")
    public UserRelation setParent(@RequestBody User[] users){
        //throw new RuntimeException("Contact Support!!");
        userRelationService.setUserRelation("anurag",users[1]);

        return null;
    }

}
