package com.m4u.estude.util;

import com.m4u.estude.model.Student;

public class StudentCreator {
    public static Student createStudent() {
        return Student.builder()
                .name("Rafael V. dos Santos")
                .email("rafael@email.com")
                .age(35)
                .build();
    }

    public static Student createInvalidStudent(String name, String email, int age) {
        return Student.builder()
                .name(name)
                .email(email)
                .age(age)
                .build();
    }

    public static Student createValidUpdateStudent() {
        return Student.builder()
                .id(1L)
                .name("Joaninha")
                .email("joani@email.com")
                .age(19)
                .build();
    }
}
