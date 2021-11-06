package com.m4u.estude.dto;


import com.m4u.estude.model.Student;
import lombok.Getter;

@Getter
public class StudentDTO {
    private String name;
    private int age;
    private String email;

    public Student studentDTO(){
        return new Student(name, age, email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


