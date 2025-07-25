package com.example.studentmanager.repository;

import com.example.studentmanager.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository  extends JpaRepository<StudentEntity, Integer> {
    List<StudentEntity> findByNameIgnoreCase(String name);
    List<StudentEntity> findByName(String name);
    List<StudentEntity> findByNameContainingIgnoreCase(String kyeword);
}
