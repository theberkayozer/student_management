package com.example.studentmanager.converter;

import com.example.studentmanager.dto.AddressDTO;
import com.example.studentmanager.entity.AddressEntity;
import com.example.studentmanager.entity.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressConverter {
    public AddressEntity dtoToEntity(AddressDTO addressDTO, StudentEntity student){
        AddressEntity entity = new AddressEntity();
        entity.setStreet(addressDTO.getStreet());
        entity.setCity(addressDTO.getCity());
        entity.setCountry(addressDTO.getCountry());
        entity.setStudent(student);

        return entity;
        
    }

    public AddressDTO entityToDTO(AddressEntity entity ){
        AddressDTO dto = new AddressDTO();
        dto.setStreet(entity.getStreet());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        return dto;
    }

    public List<AddressDTO> entityListToDTOList(List<AddressEntity> entityList) {
        List<AddressDTO> dtoList = new ArrayList<>();
        for (AddressEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    public List<AddressEntity> dtoListToEntityList(List<AddressDTO> dtoList, StudentEntity student) {
        List<AddressEntity> entityList = new ArrayList<>();
        for (AddressDTO dto : dtoList) {
            entityList.add(dtoToEntity(dto, student));
        }
        return entityList;
    }



}
