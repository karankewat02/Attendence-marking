package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.User;

public interface UserRepo extends JpaRepository<User, String> {
    User findByIdl(String email);

    User findById(Integer id);
}
    

