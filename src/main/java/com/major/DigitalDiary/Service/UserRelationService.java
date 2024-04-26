package com.major.DigitalDiary.Service;

import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Model.UserRelation;
import com.major.DigitalDiary.Repository.UserRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRelationService {

    @Autowired
    UserRelationRepository userRelationRepository;

    @Autowired
    UserService userService;

    public UserRelation findChildUser(User parentUserId){
        return userRelationRepository.findUserRelationByParentUserId(parentUserId);
    }
    public UserRelation findParentUser(User childUserId){
        return userRelationRepository.findUserRelationByUserId(childUserId);
    }
    public UserRelation setUserRelation(String username, User parent){
        User child = userService.findUserByUsername(username);
        UserRelation userRelation = findParentUser(child);
        if(userRelation !=null){
            userRelation.setParentUserId(parent);
        }else{
            userRelation = new UserRelation();
            userRelation.setUserId(child);
            userRelation.setParentUserId(parent);
        }
        return userRelationRepository.save(userRelation);
    }
}
