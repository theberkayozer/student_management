package com.example.studentmanager.service;

import com.example.studentmanager.dto.UserDTO;


public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO login(UserDTO userDTO);

}
