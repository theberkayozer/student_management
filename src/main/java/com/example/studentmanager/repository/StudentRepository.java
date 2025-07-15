package com.example.studentmanager.repository;

import com.example.studentmanager.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<StudentEntity, Integer> {

}
