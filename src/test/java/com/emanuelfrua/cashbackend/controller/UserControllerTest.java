package com.emanuelfrua.cashbackend.controller;

import com.emanuelfrua.cashbackend.dto.UserDTO;
import com.emanuelfrua.cashbackend.model.User;
import com.emanuelfrua.cashbackend.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void getAllUsers() {

    }

    @Test
    void getUserById() {
    }

    @Test
    void createUser() {
        User user = new User("test@test.com", "Pepe", "Argento");
        User saveInDB = testEntityManager.persist(user);
        User getFromDB = userRepository.getById(saveInDB.getId());
        Assertions.assertThat(getFromDB).isEqualTo(saveInDB);
    }

    @Test
    void updateUser() {

    }

    @Test
    void deleteUser() {
    }
}