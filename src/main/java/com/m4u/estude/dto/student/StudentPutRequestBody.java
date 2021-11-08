package com.m4u.estude.dto.student;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class StudentPutRequestBody {
//    @NotEmpty(message = "The student id cannot be empty")
    private Long id;

    @NotEmpty(message = "The student name cannot be empty/null")
    private String name;

    @Email
    @NotEmpty(message = "The student email cannot be empty")
    private String email;

    @Min(value = 6, message = "Age must be at least 6")
    private Integer age;
}
