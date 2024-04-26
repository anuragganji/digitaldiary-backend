package com.major.DigitalDiary.Repository;

import com.major.DigitalDiary.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    void deleteUserByUserId(Long id);
    User findUserByUserId(Long id);
    User findUserByUsername(String username);
}
