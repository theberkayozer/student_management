/* package com.example.studentmanager.controller;

import com.example.studentmanager.model.StudentEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    Map<Integer, StudentEntity> studentsMap = new HashMap<>();
    private int autoIncrementId ;
    @PostMapping("/add")
    public ResponseEntity<Map<Integer, StudentEntity>> addStudent(@Valid @RequestBody StudentEntity student) {
        student.setId(autoIncrementId);              // otomatik ID ata
        studentsMap.put(autoIncrementId, student);   // Map'e ekle
        autoIncrementId++;                           // ID sayaç +1
        return ResponseEntity.ok(studentsMap);
    }


    @GetMapping("/get/all")
    public ResponseEntity<Map<Integer, StudentEntity>> getAllStudents() {
        return ResponseEntity.ok(studentsMap);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable int id) {
        StudentEntity student = studentsMap.get(id);
        if(student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<Integer, StudentEntity>> deleteStudent(@PathVariable int id) {
        StudentEntity student = studentsMap.get(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        studentsMap.remove(id);
        return ResponseEntity.ok(studentsMap);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Map<Integer, StudentEntity>> updateStudent(@PathVariable int id, @RequestBody StudentEntity student) {
        StudentEntity student1 = studentsMap.get(id);
        if (student1 == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
        student.setId(id);
        studentsMap.put(id, student);
        return ResponseEntity.ok(studentsMap);
    }
    @GetMapping("/sorted")
    public ResponseEntity<List<StudentEntity>> getAllsSortedById(){
        List<StudentEntity> studentList =new ArrayList<>();
        for (StudentEntity student : studentsMap.values()) {
            studentList.add(student);
        }
        studentList.sort(Comparator.comparing(StudentEntity::getId));
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/sorted/average")
    public ResponseEntity<List<StudentEntity>> getAllSortedByAverage(){
        List<StudentEntity> studentList = new ArrayList<>();
        for (StudentEntity student : studentsMap.values()){
            studentList.add(student);
        }
        studentList.sort(Comparator.comparing(StudentEntity::getAverage).reversed());
        return ResponseEntity.ok(studentList);
    }


}
*/
