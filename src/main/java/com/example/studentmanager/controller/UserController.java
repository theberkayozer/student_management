package com.example.studentmanager.controller;

import com.example.studentmanager.dto.UpdatePasswordDTO;
import com.example.studentmanager.dto.UserDTO;
import com.example.studentmanager.model.UserEntity;
import com.example.studentmanager.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Yeni Kullanıcı Kaydı", description = "Bu endpoint ile yeni bir kullanıcı sistem dahil edilir")
    @PostMapping("/register")
    public ResponseEntity<UserDTO> userRegister(@Valid @RequestBody UserDTO userDTO) {

        UserDTO savedUser = userService.register(userDTO);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }
    @Operation(summary = "Kullanıcı Giriş İşlemi")
    @PostMapping("/login")
    public ResponseEntity<UserDTO> userLogin(@Valid @RequestBody UserDTO userDTO) {

        UserDTO loginUser = userService.login(userDTO);

        return new ResponseEntity<>(loginUser, HttpStatus.ACCEPTED);
    }
    @Operation(summary = "İd ile eşleşen Email Güncelleme")
    @PatchMapping("/updateEmail/{id}")
    public ResponseEntity<UserDTO> updateUserEmail(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateEmail(id, userDTO);

        return ResponseEntity.ok(updatedUser);

    }
    @Operation(summary = "Kullanıcı Şifre Güncelleme")
    @PatchMapping("/updatepassword/{id}")
    public ResponseEntity<UserDTO> updatePassword(@PathVariable Integer id, @Valid @RequestBody UpdatePasswordDTO user) {
        UserDTO updatedUser = userService.updatePassword(id,user.getPassword());

        return ResponseEntity.ok(updatedUser);


    }
}