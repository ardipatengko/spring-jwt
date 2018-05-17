package com.example.springjwt.springjwt.persistence.service;

import com.example.springjwt.springjwt.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findByUserName(String userName);
}
