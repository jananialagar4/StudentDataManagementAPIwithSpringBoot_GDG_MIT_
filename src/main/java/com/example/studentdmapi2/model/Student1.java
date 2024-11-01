package com.example.studentdmapi2.model;

import jakarta.validation.constraints.*;

public class Student1 {
    private Integer id;  //auto-incrementing Id

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Positive(message = "Age must be positive")
    private Integer age;

    private String course;

    @Min(value = 0, message = "Marks cannot be negative")
    private Double marks;

    private Boolean feesPaid;

    public Student1() {
    }

    public Student1(String name, Integer age, String course, Double marks, Boolean feesPaid) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
        this.feesPaid = feesPaid;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Boolean getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(Boolean feesPaid) {
        this.feesPaid = feesPaid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", marks=" + marks +
                ", feesPaid=" + feesPaid +
                '}';
    }
}
