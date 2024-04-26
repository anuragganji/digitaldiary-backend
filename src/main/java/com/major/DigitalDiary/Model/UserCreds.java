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

    // Constructors, getters, and setters
}