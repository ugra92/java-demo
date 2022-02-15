package com.example.demo.user.business;

import com.example.demo.user.database.UserRepository;
import com.example.demo.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> dbUser = userRepository.findUserByEmail(user.getEmail());
        if (dbUser.isPresent()) {
            throw new IllegalStateException("email exists!");
        }

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        boolean userExists = userRepository.existsById(id);
        if (!userExists) {
            throw new IllegalStateException("User does not exist");
        }

        userRepository.deleteById(id);
    }

    public void editUser(User user) {
        User dbUser = userRepository.findById(user.getId()).orElseThrow(() -> new IllegalStateException("User does not exist"));
        dbUser.setName(user.getName()).setLastname(user.getLastname()).setEmail(user.getEmail());
        userRepository.save(dbUser);
    }
}
