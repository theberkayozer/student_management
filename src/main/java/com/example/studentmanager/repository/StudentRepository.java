package com.example.studentmanager.repository;

import com.example.studentmanager.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository  extends JpaRepository<StudentEntity, Integer> {
    List<StudentEntity> findByNameIgnoreCase(String name);
}
