package com.emanuelfrua.cashbackend.controller;

import com.emanuelfrua.cashbackend.model.Loan;
import com.emanuelfrua.cashbackend.model.User;
import com.emanuelfrua.cashbackend.repository.LoanRepository;
import com.emanuelfrua.cashbackend.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.hibernate.AssertionFailure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class LoanControllerTest {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void getLoansByPageAndSize() {
    }

    @Test
    void createLoan() {

        User user = new User("test@test.com", "Pepe", "Argento");
        User userSaveInDB = testEntityManager.persist(user);
        Loan loan = new Loan(100.50, userSaveInDB);
        Loan loanSaveInDB = testEntityManager.persist(loan);
        Loan loanGetFromDB = loanRepository.getById(loanSaveInDB.getId());

        Assertions.assertThat(loanGetFromDB).isEqualTo(loanSaveInDB);

    }

    @Test
    void updateLoan() {
    }

    @Test
    void deleteLoan() {
    }
}