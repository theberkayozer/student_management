package com.example.studentmanager.controller;

import com.example.studentmanager.users.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    Map<Integer, Student> studentsMap = new HashMap<>();
    private int autoIncrementId ;
    @PostMapping("/add")
    public ResponseEntity<Map<Integer,Student>> addStudent(@RequestBody Student student) {
        student.setId(autoIncrementId);              // otomatik ID ata
        studentsMap.put(autoIncrementId, student);   // Map'e ekle
        autoIncrementId++;                           // ID sayaç +1
        return ResponseEntity.ok(studentsMap);
    }


    @GetMapping("/get/all")
    public ResponseEntity<Map<Integer,Student>> getAllStudents() {
        return ResponseEntity.ok(studentsMap);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Student student = studentsMap.get(id);
        if(student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<Integer,Student>> deleteStudent(@PathVariable int id) {
        Student student = studentsMap.get(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        studentsMap.remove(id);
        return ResponseEntity.ok(studentsMap);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Map<Integer,Student>> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student student1 = studentsMap.get(id);
        if (student1 == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
        student.setId(id);
        studentsMap.put(id, student);
        return ResponseEntity.ok(studentsMap);
    }
    @GetMapping("/sorted")
    public List<Student> getAllsSortedById(){
        List<Student> studentList =new ArrayList<>();
        for (Student student : studentsMap.values()) {
            studentList.add(student);
        }
        studentList.sort(Comparator.comparing(Student::getId));
        return studentList;
    }

    @GetMapping("/sorted/average")
    public List<Student> getAllSortedByAverage(){
        List<Student> studentList = new ArrayList<>();
        for (Student student : studentsMap.values()){
            studentList.add(student);
        }
        studentList.sort(Comparator.comparing(Student::getAverage).reversed());
        return studentList;
    }


}
