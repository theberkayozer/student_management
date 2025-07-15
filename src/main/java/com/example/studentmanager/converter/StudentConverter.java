package com.example.studentmanager.converter;

import com.example.studentmanager.dto.StudentDTO;
import com.example.studentmanager.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentConverter {

    public StudentEntity DTOtoEntity(StudentDTO studentDTO){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDTO.getId());
        studentEntity.setName(studentDTO.getName());
        studentEntity.setAverage(studentDTO.getAverage());

        return studentEntity;
    }
    public StudentDTO EntitytoDTO(StudentEntity studentEntity){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentDTO.setName(studentEntity.getName());
        studentDTO.setAverage(studentEntity.getAverage());
        if (studentEntity.getStatus() == StudentEntity.Status.PASSED)
            studentDTO.setStatus(StudentDTO.Status.PASSED);
        else
            studentDTO.setStatus(StudentDTO.Status.FAILED);

        return studentDTO;
    }



}
