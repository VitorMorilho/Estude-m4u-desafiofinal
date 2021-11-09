package com.m4u.estude.dto.user;

import com.m4u.estude.model.Student;
import com.m4u.estude.model.User;

import javax.validation.constraints.NotEmpty;

public class UserPostRequestBody {
    @NotEmpty(message = "Username field is required")
    private String username;

    @NotEmpty(message = "Password field is required")
    private String password;

    @NotEmpty(message = "Student field is required")
    private Student student;

    public void userDto() {
//    return new User( user, password);
    }

    public UserPostRequestBody(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.student = user.getStudent();
    }

    public String getUsername() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
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
}