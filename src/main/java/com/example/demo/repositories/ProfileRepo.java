package com.example.demo.repositories;

import com.example.demo.model.Profile;
import com.example.demo.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfileRepo extends JpaRepository<Profile,Integer> {
    Profile findByUser(User user);

}
