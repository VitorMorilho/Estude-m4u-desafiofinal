package com.m4u.estude.controller.converter;

import com.m4u.estude.dto.UserDTO;
import com.m4u.estude.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User toModel (UserDTO userDTO){
        User user = new User();
        user.setUser(userDTO.getUser());

        return user;
    }
    public UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUser(user.getUser());

        return userDTO;
    }
}