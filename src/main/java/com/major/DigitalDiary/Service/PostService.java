package com.major.DigitalDiary.Service;

import com.major.DigitalDiary.Model.Post;
import com.major.DigitalDiary.Model.Trip;
import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final TripService tripService;
    private final UserService userService;

    public PostService(PostRepository postRepository, TripService tripService, UserService userService) {
        this.postRepository = postRepository;
        this.tripService = tripService;
        this.userService = userService;
    }

    public Post createPost(Post post, String username, Long trip_id) {
        User user = userService.findUserByUsername(username);
        Trip trip = tripService.findTripById(trip_id);
        System.out.println("User: " + user);
        post.setUserId(user);
        post.setTripId(trip);
        System.out.println("Post: " + post);
        Post newPost = postRepository.save(post);
        return newPost;
    }

//    Entry oldEntry = postRepository.findEntryByEntryDate(entry.getEntryDate());
//        if(oldEntry !=null){
//        oldEntry.setContent(oldEntry.getContent()+"     "+entry.getContent());
//        return entryRepository.save(oldEntry);
//    }else{
//        return entryRepository.save(entry);
//    }

    public List<Post> findAllPosts(Long tripId) {
        Trip trip = tripService.findTripById(tripId);
        return postRepository.findAllPostsByTripId(trip);
    }
}
