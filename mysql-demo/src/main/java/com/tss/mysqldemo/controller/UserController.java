package com.tss.mysqldemo.controller;

import com.tss.mysqldemo.model.User;
import com.tss.mysqldemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public String addNewUser(@RequestParam String name, @RequestParam String email) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        userRepository.save(newUser);
        return "User Saved!";
    }


    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }



}
