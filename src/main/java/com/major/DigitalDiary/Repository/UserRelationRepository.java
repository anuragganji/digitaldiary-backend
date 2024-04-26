package com.major.DigitalDiary.Repository;

import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Model.UserRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRelationRepository extends JpaRepository<UserRelation, Long> {
    UserRelation findUserRelationByParentUserId(User parentUserId);
    UserRelation findUserRelationByUserId(User childUserId);
}
