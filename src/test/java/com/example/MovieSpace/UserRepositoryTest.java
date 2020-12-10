package com.example.MovieSpace;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.MovieSpace.domain.User;
import com.example.MovieSpace.domain.UserRepository;



@DataJpaTest
public class UserRepositoryTest {
	@Autowired
    private UserRepository repository;
	
	@Test
    public void findByUsernameShouldReturnUser() {
        User user = repository.findByUsername("user");
        
        assertThat(user.getRole()).isEqualTo("USER");
    }
}
