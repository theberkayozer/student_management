package com.example.studentmanager.controller;

import com.example.studentmanager.dto.StudentDTO;
import com.example.studentmanager.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentControllerV2 {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody StudentDTO studentDTO) {
        StudentDTO savedStudent = studentService.saveStudent(studentDTO);
        return ResponseEntity.ok(savedStudent);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer id) {
        StudentDTO student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentDTO studentDTO) {
        StudentDTO updatedStudent = studentService.updateStudent(id, studentDTO);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<StudentDTO>> getAllsSortedById() {
        List<StudentDTO> sortedList = studentService.getAllStudentsSortedById();
        return ResponseEntity.ok(sortedList);
    }

    @GetMapping("/sorted/average")
    public ResponseEntity<List<StudentDTO>> getAllSortedByAverage() {
        List<StudentDTO> sortedList = studentService.getAllStudentsSortedByAverage();
        return ResponseEntity.ok(sortedList);
    }
}
