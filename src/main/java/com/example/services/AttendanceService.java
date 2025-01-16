package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Attendence;
import com.example.model.User;
import com.example.repo.AttendenceRepo;
import com.example.repo.UserRepo;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private AttendenceRepo attendanceRepository;

    // Define a valid IP range for the network (e.g., campus or office network)
    private static final String VALID_IP_RANGE = "192.168.1.";  // Adjust this based on your network

    // Method to mark attendance for a user based on IP address and email
    public String markAttendance(String email, String ipAddress) {
        // Check if the IP address falls within the valid range
        if (isValidIp(ipAddress)) {
            // Find the user by email (using Optional)
            Optional<User> userOptional = userRepository.findById(email);

            // Check if user is present
            if (userOptional.isPresent()) {
                User user = userOptional.get();  // Get user from Optional

                // Mark attendance for the user
                  Attendence attendance = new Attendence();  // Use the correct entity name (Attendance)
                attendance.setUserId(user.getId());  // Set userId as user.getId()
                attendance.setUserName(user.getName());  // Set the userName
                attendance.setTimestamp(LocalDateTime.now());  // Set current timestamp
                attendance.setIpAddress(ipAddress);  // Set the provided IP address

                // Save attendance to the database
                attendanceRepository.save(attendance);

                return "Attendance marked for " + user.getName() + " from IP: " + ipAddress;
            } else {
                return "User not found!";
            }
        } else {
            return "Invalid IP address!";
        }
    }

    // Helper method to validate the IP address
    private boolean isValidIp(String ipAddress) {
        // Check if the IP address starts with the valid IP range (e.g., 192.168.1.x)
        return ipAddress.startsWith(VALID_IP_RANGE);
    }

    // Save a new user to the database
    public User saveUser(User user) {
        // You can add custom logic here, like validation or transformation
        return userRepository.save(user);
    }
}
