package com.example.demo.user.business;

import com.example.demo.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getUsers()
    {
        return List.of(new User());
    }
}
