package com.major.DigitalDiary.Service;

import com.major.DigitalDiary.Exception.UserNotFoundException;
import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        //user.setUsername(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

   public User findUserByUserId(Long userId){
     return userRepository.findUserByUserId(userId);//.orElseThrow(()->new UserNotFoundException("User by id "+ userId +" not found!"));
   }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public User findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    @Transactional
    public void deleteUser(Long id){
        userRepository.deleteUserByUserId(id);
    }
}
