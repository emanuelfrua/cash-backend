package com.emanuelfrua.cashbackend.controller;

import com.emanuelfrua.cashbackend.dto.UserDTO;
import com.emanuelfrua.cashbackend.exception.ResourceNotFoundException;
import com.emanuelfrua.cashbackend.model.User;
import com.emanuelfrua.cashbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // get all Users
    @GetMapping("users")
    public List<UserDTO> getAllUsers() {
        return this.userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    // get user by id
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + userId));
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    // save user
    @PostMapping("users")
    public User createUser(@Valid @RequestBody User user) {
        return this.userRepository.save(user);
    }

    // update user
    @PutMapping("users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + userId));
        user.setEmail(userDetails.getEmail());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        final User userUpdated = userRepository.save(user);
        return ResponseEntity.ok(userUpdated);
    }

    // delete user
    @DeleteMapping("users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + userId));
        this.userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
