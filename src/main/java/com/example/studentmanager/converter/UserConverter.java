package com.example.studentmanager.converter;

import com.example.studentmanager.dto.UserDTO;
import com.example.studentmanager.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity userDTOtoEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        return userEntity;
    }

    public UserDTO userEntitytoDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(userEntity.getEmail());
        return userDTO;
    }
}
