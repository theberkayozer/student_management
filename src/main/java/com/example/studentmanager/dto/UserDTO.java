package com.example.studentmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public class UserDTO {
    @NotBlank(message = "Email alanı boş olamaz.")
    @Email
    @Schema(description = "Kullanıcının kayıt olduğu email" ,example = "berkayozer@gmail.com")
    private String email;
    @Size(min = 6 , message = "Şifre en az 6 karekter içermelidir.")
    @NotBlank
    @Schema(description = "Kullanıcının şifresi" ,example = "password123")
    private String password;

    public @NotBlank(message = "Email alanı boş olamaz.") @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email alanı boş olamaz.") @Email String email) {
        this.email = email;
    }

    public @Size(min = 6, message = "Şifre en az 6 karekter içermelidir.") @NotBlank String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 6, message = "Şifre en az 6 karekter içermelidir.") @NotBlank String password) {
        this.password = password;
    }
}
