package com.example.studentmanager.service;

import com.example.studentmanager.dto.UserDTO;
import com.example.studentmanager.model.StudentEntity;
import com.example.studentmanager.model.UserEntity;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO login(UserDTO userDTO);

}
