package com.m4u.estude.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", referencedColumnName = "tbl_id", nullable = true)
//    private User user;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "address_id", referencedColumnName = "tbl_id_address", nullable = true)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Address> address = new ArrayList<>();
}
