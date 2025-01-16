package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repo.UserRepo;

@Service 
public class UserService {
    
     @Autowired
    private UserRepo userRepository;

    // Method to save a user
    public User saveUser(User user) {
        // You can add custom logic here, like validation or transformation
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }
}
