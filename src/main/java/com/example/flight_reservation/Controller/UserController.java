package com.example.flight_reservation.Controller;

import com.example.flight_reservation.Dto.LoginRequest;
import com.example.flight_reservation.Model.User;
import com.example.flight_reservation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        User authenticatedUser = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (authenticatedUser != null) {
            // Return the user ID in the response
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("id", authenticatedUser.getId());

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}

