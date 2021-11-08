package com.m4u.estude.util;

import com.m4u.estude.dto.student.StudentPostRequestBody;
import com.m4u.estude.dto.student.StudentPutRequestBody;

public class StudentPutRequestBodyCreator {
    public static StudentPutRequestBody createStudentPutRequestBody() {
        return StudentPutRequestBody.builder()
                .id(StudentCreator.createValidUpdateStudent().getId())
                .name(StudentCreator.createValidUpdateStudent().getName())
                .email(StudentCreator.createValidUpdateStudent().getEmail())
                .age(StudentCreator.createValidUpdateStudent().getAge())
                .build();
    }
}
