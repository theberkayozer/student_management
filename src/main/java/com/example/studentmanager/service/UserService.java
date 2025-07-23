package com.example.studentmanager.service;

import com.example.studentmanager.dto.UserDTO;


public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO login(UserDTO userDTO);
    UserDTO updateEmail(Integer id ,UserDTO userDTO);
   // UserDTO updatePassword(Integer id, UserDTO userDTO);
     UserDTO updatePassword(Integer id, String password);

}
