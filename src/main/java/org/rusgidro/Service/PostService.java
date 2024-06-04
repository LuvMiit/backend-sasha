package org.rusgidro.Service;

import lombok.RequiredArgsConstructor;
import org.rusgidro.entity.Post;
import org.rusgidro.repos.PostRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepo postRepo;

    public Post getPostByName(String postName){
        return postRepo.findByPostName(postName);
    }

    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }
}
