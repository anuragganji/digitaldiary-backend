package com.major.DigitalDiary.Model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String content;

    private Date postDate;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "tripId")
    private Trip trip;

    // Constructors, getters, and setters
}
