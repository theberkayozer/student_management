package com.example.studentmanager.service;

import com.example.studentmanager.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO saveStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Integer id);

    StudentDTO updateStudent(Integer id, StudentDTO studentDTO);

    StudentDTO  deleteStudent(Integer id);

    List<StudentDTO> getAllStudentsSortedById();

    List<StudentDTO> getAllStudentsSortedByAverage();


    List<StudentDTO> sortedStudentByName();

    List<StudentDTO> sortedStudentByNameWithOrder();

    List<StudentDTO> filterByAverage(Double minAverage);
}
