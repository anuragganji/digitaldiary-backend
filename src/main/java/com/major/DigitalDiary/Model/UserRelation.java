package com.major.DigitalDiary.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_relations")
public class UserRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relationId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", unique = true)
    private User userId;

    @OneToOne
    @JoinColumn(name = "parent_user_id", referencedColumnName = "userId", unique = true)
    private User parentUserId;

    // Constructors, getters, and setters

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public User getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(User parentUserId) {
        this.parentUserId = parentUserId;
    }

    @Override
    public String toString() {
        return "UserRelation{" +
                "relationId=" + relationId +
                ", userId=" + userId +
                ", parentUserId=" + parentUserId +
                '}';
    }
}