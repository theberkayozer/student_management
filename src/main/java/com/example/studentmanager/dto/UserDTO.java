package com.example.studentmanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @NotBlank(message = "Email alanı boş olamaz.")
    @Email
    private String email;
    @Size(min = 6 , message = "Şifre en az 6 karekter içermelidir.")
    @NotBlank
    private String password;

}
