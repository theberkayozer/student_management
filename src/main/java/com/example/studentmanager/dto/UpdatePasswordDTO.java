package com.example.studentmanager.dto;

import jakarta.validation.constraints.Size;

public class UpdatePasswordDTO {
    @Size(min = 6, message = "Şifre en az 6 karakter olmalı")
    private String password;

    public @Size(min = 6, message = "Şifre en az 6 karakter olmalı") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 6, message = "Şifre en az 6 karakter olmalı") String password) {
        this.password = password;
    }
}
