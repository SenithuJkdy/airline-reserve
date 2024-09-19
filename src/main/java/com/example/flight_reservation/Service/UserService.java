package com.example.flight_reservation.Service;

import com.example.flight_reservation.Model.User;
import com.example.flight_reservation.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Optionally check for existing users or add encryption for passwords
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User authenticate(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Check the password (you should use password encryption, like BCrypt)
            if (user.getPassword().equals(password)) {
                return user; // Return the User object if authentication is successful
            }
        }
        return null; // Return null if authentication fails
    }

}
