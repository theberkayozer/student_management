package com.example.studentmanager.controller;

import com.example.studentmanager.dto.UserDTO;
import com.example.studentmanager.service.UserService;
import com.example.studentmanager.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> userRegister(@RequestBody UserDTO userDTO){

       UserDTO savedUser =  userService.register(userDTO);

        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);

    }
























}
