package com.major.DigitalDiary.Controller;

import com.major.DigitalDiary.Model.Post;
import com.major.DigitalDiary.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "${frontend.origin}")
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all/{trip_id}")
    public ResponseEntity<List<Post>> getAllPosts(@PathVariable("trip_id") Long tripId) {
        List<Post> posts = postService.findAllPosts(tripId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping(path = "/create/{trip_id}/{username}")
    public ResponseEntity<Post> createPost(@PathVariable String username, @PathVariable Long trip_id, @RequestBody Post post) {
        System.out.println("Post Details");
        System.out.println(post);
        System.out.println("Username: " + username);

        //throw new RuntimeException("Contact Support!!");

        postService.createPost(post, username, trip_id);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
    
}
