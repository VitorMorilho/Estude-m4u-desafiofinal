package com.m4u.estude.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Objects;


@Entity
@Table(name = "tbl_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tbl_id_student", nullable = false)
    private Integer id;

    @Column(name = "tbl_name", length = 35, nullable = false)
    private String name;

    @Column(name = "tbl_age")
    private int age;

    @Email(message = "Email inválido")
    @Column(name = "tbl_email", length = 35, nullable = false, unique = true)
    private String email;

    public Student(){

    }

    public Student(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Student(Integer id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
