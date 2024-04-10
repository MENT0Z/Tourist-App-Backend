package com.example.demo.repositories;

import com.example.demo.model.User;
import com.example.demo.payloads.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByphone(String phone);
}
