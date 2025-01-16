package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Attendence;



public interface AttendenceRepo extends JpaRepository<Attendence, String>{
    
}
