package com.manytoone.service;

import com.manytoone.model.Post;
import com.manytoone.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceClass {

    @Autowired
    private PostRepo repo;

    public Post addPost(Post post) {
        return repo.save(post);
    }

    public ResponseEntity<Post> getPostById(long id) throws ResourceNotFoundException{
        Post post = repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Post not found with id "+id));
        return ResponseEntity.ok(post);
    }

    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    public void deletePostById(long id) throws ResourceNotFoundException{
        repo.deleteById(id);
    }

    public Post updatePostById(Post post, long id) {
        Post existingPost = repo.findById(id).get();
        if(post.getDescription()!=null)
            existingPost.setDescription(post.getDescription());
        if(post.getTitle()!=null)
            existingPost.setTitle(post.getTitle());
        return repo.save(existingPost);
    }
}
