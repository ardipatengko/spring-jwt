package com.example.springjwt.springjwt;

import com.example.springjwt.springjwt.persistence.service.UserService;
import com.example.springjwt.springjwt.persistence.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoSpringConfig {
    @Bean
    public UserService userService() { return new UserServiceImpl(); }
}
