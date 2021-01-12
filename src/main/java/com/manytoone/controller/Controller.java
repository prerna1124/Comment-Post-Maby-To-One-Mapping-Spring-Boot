package com.manytoone.controller;

import com.manytoone.model.Post;
import com.manytoone.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private ServiceClass service;

    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post)
    {
        return service.addPost(post);
    }
}
