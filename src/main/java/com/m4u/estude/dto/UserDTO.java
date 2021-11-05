package com.m4u.estude.dto;

import com.m4u.estude.model.User;

public class UserDTO {
    private String user;

    public User userDto() {
    return new User(user);
        }

}


