package com.major.DigitalDiary.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_creds")
public class UserCreds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userCredId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", unique = true)
    private User user;

    private String password;

    public Long getUserCredId() {
        return userCredId;
    }

    public void setUserCredId(Long userCredId) {
        this.userCredId = userCredId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserCreds{" +
                "userCredId=" + userCredId +
                ", user=" + user +
                ", password='" + password + '\'' +
                '}';
    }

    // Constructors, getters, and setters
}