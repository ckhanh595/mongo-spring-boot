package com.spring.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "student")
public class Student {
    @Id
    private String id;

    @Field(name = "name")
    private String name;

    private String email;

    private int age;

    private Department department;

    private List<Subject> subjects;

    @Transient
    private double percentage;

//    public Student() {
//    }
//
//    @PersistenceConstructor
//    public Student(String id, String name, String email, Department department, List<Subject> subjects) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.department = department;
//        this.subjects = subjects;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public double getPercentage() {
        if (subjects != null && subjects.size() > 0) {
           return (double) subjects.stream().mapToInt(Subject::getMarksObtained).sum() / subjects.size();
        }
        return 0.00;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
