package com.example.studentmanager.entity;

import jakarta.persistence.*;

@Entity
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;

    private String city;

    private String country;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    public AddressEntity() {
    }

    public AddressEntity(String street, String city, String country, StudentEntity student) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
