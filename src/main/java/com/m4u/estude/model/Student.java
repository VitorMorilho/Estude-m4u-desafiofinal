package com.m4u.estude.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tbl_id_student", nullable = false)
    private Long id;

    @Column(name = "tbl_name", length = 35, nullable = false)
    @NotEmpty(message = "The student name cannot be empty/null")
    private String name;

    @Column(name = "tbl_age", nullable = false)
    @Min(value = 6, message = "Age must be at least 6")
    private Integer age;

    @Column(name = "tbl_email", length = 35, nullable = false, unique = true)
    @Email
    @NotEmpty(message = "The student email cannot be empty")
    private String email;
}
