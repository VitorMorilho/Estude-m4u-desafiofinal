package com.m4u.estude.dto;

import com.m4u.estude.model.User;

public class UserDTO {
    private Integer id;
    private String user;
    private String password;

    public User userDto() {
    return new User(id, user, password);
    }

    public UserDTO() {
        this.id = id;
        this.user = user;
        this.password = password;
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
}


