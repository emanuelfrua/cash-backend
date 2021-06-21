package com.emanuelfrua.cashbackend.dto;

import com.emanuelfrua.cashbackend.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private List<LoanDTO> loans;

    public UserDTO(User user) {
        this.setId(user.getId());
        this.setEmail(user.getEmail());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setLoans(user
                .getLoanList()
                .stream()
                .map(LoanDTO::new)
                .collect(Collectors.toList())
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<LoanDTO> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanDTO> loans) {
        this.loans = loans;
    }

}
