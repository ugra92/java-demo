package com.example.demo.user.controller;

import com.example.demo.user.business.UserService;
import com.example.demo.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping()
    public void addUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping( "{userId}")
    public void deleteUser(@PathVariable("userId") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("")
    public void editUser(@RequestBody User user) {
        userService.editUser(user);
    }
}
