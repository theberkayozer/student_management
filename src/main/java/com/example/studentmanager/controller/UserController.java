package com.example.studentmanager.controller;

import com.example.studentmanager.dto.UserDTO;
import com.example.studentmanager.model.UserEntity;
import com.example.studentmanager.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
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
    public ResponseEntity<UserDTO> userRegister(@Valid @RequestBody UserDTO userDTO) {

        UserDTO savedUser = userService.register(userDTO);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> userLogin(@Valid @RequestBody UserDTO userDTO) {

        UserDTO loginUser = userService.login(userDTO);

        return new ResponseEntity<>(loginUser, HttpStatus.ACCEPTED);
    }


}
