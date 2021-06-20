package com.emanuelfrua.cashbackend.controller;

import com.emanuelfrua.cashbackend.exception.ResourceNotFoundException;
import com.emanuelfrua.cashbackend.model.Loan;
import com.emanuelfrua.cashbackend.model.User;
import com.emanuelfrua.cashbackend.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;
//
//    // get all Loans
//    @GetMapping("/loans")
//    public List<Loan> getAllLoans() {
//        return this.loanRepository.findAll();
//    }

    // get loans by page and size
    @GetMapping("/loans")
    public Pageable getLoansByPageAndSize(
            @RequestParam(required = true, value = "page") int page,
            @RequestParam(required = true, value = "size") int size,
            @RequestParam(required = false, value = "user_id") Long userId
    ) {
        Pageable pageObj = PageRequest.of(page, size);
        Page<Loan> loanPage = this.loanRepository.findAll(pageObj);
        return pageObj;

    }

//    // save user
//    @PostMapping("users")
//    public User createUser(@Valid @RequestBody User user) {
//        return this.userRepository.save(user);
//    }
//
//    // update user
//    @PutMapping("users/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
//        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + userId));
//        user.setEmail(userDetails.getEmail());
//        user.setFirstName(userDetails.getFirstName());
//        user.setLastName(userDetails.getLastName());
//        final User userUpdated = userRepository.save(user);
//        return ResponseEntity.ok(userUpdated);
//    }
//
//    // delete user
//    @DeleteMapping("users/{id}")
//    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
//        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + userId));
//        this.userRepository.delete(user);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
}
