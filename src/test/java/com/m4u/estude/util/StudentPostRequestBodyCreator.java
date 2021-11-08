package com.m4u.estude.util;

import com.m4u.estude.dto.student.StudentPostRequestBody;

public class StudentPostRequestBodyCreator {
    public static StudentPostRequestBody createStudentPostRequestBody() {
        return StudentPostRequestBody.builder()
                .name(StudentCreator.createStudent().getName())
                .email(StudentCreator.createStudent().getEmail())
                .age(StudentCreator.createStudent().getAge())
                .build();
    }
}
