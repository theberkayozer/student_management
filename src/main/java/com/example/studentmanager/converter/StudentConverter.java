package com.example.studentmanager.converter;

import com.example.studentmanager.dto.AddressDTO;
import com.example.studentmanager.dto.StudentDTO;
import com.example.studentmanager.entity.AddressEntity;
import com.example.studentmanager.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class StudentConverter {
    @Autowired
    private AddressConverter converter;

    public StudentEntity DTOtoEntity(StudentDTO studentDTO) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDTO.getId());
        studentEntity.setName(studentDTO.getName());
        studentEntity.setAverage(studentDTO.getAverage());
        if (studentDTO.getAddresses().isEmpty()) {
            System.out.println("Adres alanı bulunamadı");
            return studentEntity;
        }
        List<AddressEntity> entityList = new ArrayList<>();
        List<AddressDTO> dtoList = studentDTO.getAddresses();
        for (AddressDTO ad : dtoList) {
            entityList.add(converter.dtoToEntity(ad, studentEntity));
        }

        studentEntity.setAddresses(entityList);


        return studentEntity;


    }

    public StudentDTO EntitytoDTO(StudentEntity studentEntity) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentDTO.setName(studentEntity.getName());
        studentDTO.setAverage(studentEntity.getAverage());
        if (studentEntity.getStatus() == StudentEntity.Status.PASSED)
            studentDTO.setStatus(StudentDTO.Status.PASSED);
        else
            studentDTO.setStatus(StudentDTO.Status.FAILED);

        List<AddressEntity> addressEntityList = studentEntity.getAddresses();
        List<AddressDTO> dtoList=new ArrayList<>();

        for(AddressEntity ae:addressEntityList){
            dtoList.add(converter.entityToDTO(ae));
        }

        studentDTO.setAddresses(dtoList);

        return studentDTO;
    }


}
