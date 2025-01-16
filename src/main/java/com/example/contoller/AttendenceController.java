package com.example.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.User;
import com.example.services.AttendanceService;
import com.example.services.UserService;

@RestController
@RequestMapping("/attendance")
public class AttendenceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // You can also create a GET endpoint to fetch user details (optional)
    // @GetMapping("/{id}")
    // public User getUser(@PathVariable String id) {
    //     return userService.getUserById(id);
    // }

    @PostMapping("/mark")
    public String markAttendance(@RequestParam String email, @RequestParam String ipAddress) {
        return attendanceService.markAttendance(email, ipAddress);
    }
}

