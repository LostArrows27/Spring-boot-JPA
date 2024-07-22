package com.example.sprintbootdemo.controller;

import com.example.sprintbootdemo.exception.UserNotFoundException;
import com.example.sprintbootdemo.model.User;
import com.example.sprintbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        User user =  userService.getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("Not found user with ID: " + id);
        }

        return user;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
