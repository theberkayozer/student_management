package com.example.studentmanager.users;

public class Student {
    public enum Status {
        PASSED,
        FAILED
    }
    private  Status status;

    private int id;
    private String name;
    private double average;

    public Student() {
    }

    public Student(int id, String name, double average) {
        this.id = id;
        this.name = name;
        this.average = average;
        if (average >= 45.00){
            status = Status.PASSED;
        }else
            status = Status.FAILED;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        if (average >= 45.00){
            status = Status.PASSED;
        }else
            status = Status.FAILED;
    }

    public Status getStatus() {
        return status;
    }
}
