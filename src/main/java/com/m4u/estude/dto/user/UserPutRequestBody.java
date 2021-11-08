package com.m4u.estude.dto.user;

import com.m4u.estude.model.Student;
import com.m4u.estude.model.User;

import javax.validation.constraints.NotEmpty;

public class UserPutRequestBody {
    @NotEmpty(message = "Username field is required")
    private String username;

    @NotEmpty(message = "Password field is required")
    private String password;

    public UserPutRequestBody() {
    }

    public UserPutRequestBody(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
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
}