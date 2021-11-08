package com.m4u.estude.dto;

import com.m4u.estude.model.User;

public class UserDTO {
    private String user;
    private String password;

    public User userDto() {
    return new User( user, password);
    }

    public UserDTO() {
        this.user = user;
        this.password = password;

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
}


