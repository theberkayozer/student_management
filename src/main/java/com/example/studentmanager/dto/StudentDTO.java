package com.example.studentmanager.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentDTO {

    public enum Status {
        PASSED, FAILED
    }
    @Schema(description = "Öğrencinin sistemdeki ID'si", example = "1")
    private Integer id;
    @NotBlank(message = "name cannot be null")
    @Schema(description = "Öğrencinin adı", example = "Ali")
    private String name;
    @Min(value = 0)
    @Max(value = 100)
    @Schema(description = "Ortalaması", example = "76.5", minimum = "0", maximum = "100")
    private double average;
    @Schema(description = "Durum: PASSED ya da FAILED", example = "PASSED")
    private Status status;
    public StudentDTO() {
    }

    public StudentDTO(Integer id, String name, double average) {
        this.id = id;
        this.name = name;
        this.average = average;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAverage(double average) {
        this.average = average;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Min(value = 0)
    @Max(value = 100)
    public double getAverage() {
        return average;
    }
}
