package com.manytoone.service;

import com.manytoone.model.Post;
import com.manytoone.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {

    @Autowired
    private PostRepo repo;

    public Post addPost(Post post) {
        return repo.save(post);
    }
}
