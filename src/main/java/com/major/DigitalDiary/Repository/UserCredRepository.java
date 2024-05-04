package com.major.DigitalDiary.Repository;

import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Model.UserCreds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredRepository extends JpaRepository<UserCreds, Long> {
    UserCreds findUserCredsByUser(User user);
}
