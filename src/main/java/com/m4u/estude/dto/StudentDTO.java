package com.m4u.estude.dto;

import com.m4u.estude.model.Student;
import lombok.Getter;

@Getter
public class StudentDTO {
    private String name;
    private int age;
    private String email;
}

//public Student studentDTO(){
//    return new Student(name, age, email);
//}

