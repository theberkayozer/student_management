package com.example.studentmanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @NotBlank
    @Email
    private String email;
    @Size(min = 6 , message = "Password must include at least 6 characters")
    private String password;

}
