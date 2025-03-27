package com.webserver.diorailway.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import com.webserver.diorailway.domain.models.UserModel;
import com.webserver.diorailway.domain.repositories.UserRepository;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable long id){
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

}
