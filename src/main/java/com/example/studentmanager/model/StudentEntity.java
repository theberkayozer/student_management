package com.example.studentmanager.model;

import jakarta.persistence.*;



@Entity
@Table(name = "STUDENT_TABLE")
public class StudentEntity {


    @Id
    private Integer id;
    private String name;
    private double average;

    private Status status;
    public enum Status {
        PASSED, FAILED
    }
    public StudentEntity() {
    }

    public StudentEntity(Integer id, String name, double average) {
        this.id = id;
        this.name = name;
        this.average = average;
        if (average >= 45.00) {
            status = Status.PASSED;
        } else status = Status.FAILED;
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

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
        if (average >= 45.00) {
            status = Status.PASSED;
        } else status = Status.FAILED;
    }

    public Status getStatus() {
        return status;
    }
}
