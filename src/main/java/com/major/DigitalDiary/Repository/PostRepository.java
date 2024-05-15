package com.major.DigitalDiary.Repository;

import com.major.DigitalDiary.Model.Post;
import com.major.DigitalDiary.Model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllPostsByTripId(Trip tripId);
}
