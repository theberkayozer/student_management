package com.example.studentmanager.repository;

import com.example.studentmanager.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity , Integer>{
    Optional<UserEntity> findByEmail(String email);
}
