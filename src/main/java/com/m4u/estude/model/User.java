package com.m4u.estude.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tbl_id")
    private Integer id;

    @Column(name = "tbl_user", length = 35, nullable = false)
    private String user;

    @Column(name = "tbl_password", length = 35, nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_id_student", referencedColumnName = "tbl_id_student", nullable = true)
    private Student student;

    public User(){

    }

    public User(Integer id, String user, String password, Student student) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.student = student;
    }

    public User (String user){
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", student=" + student +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
