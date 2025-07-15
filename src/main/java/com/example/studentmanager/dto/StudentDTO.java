package com.example.studentmanager.dto;

import com.example.studentmanager.model.StudentEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentDTO {

    public enum Status {
        PASSED, FAILED
    }

    private Integer id;
    private Status status;
    @NotBlank(message = "name cannot be null")
    private String name;

    @Min(value = 0)
    @Max(value = 100)
    private double average;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String name, double average) {
        this.id = id;
        this.name = name;
        this.average = average;
    }
    public int getId() {
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
