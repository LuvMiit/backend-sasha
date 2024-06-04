package org.rusgidro.controllers;

import lombok.RequiredArgsConstructor;
import org.rusgidro.Service.PostService;
import org.rusgidro.entity.Post;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/all")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }
}
