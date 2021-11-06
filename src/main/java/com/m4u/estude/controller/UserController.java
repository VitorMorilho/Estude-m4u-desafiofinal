package com.m4u.estude.controller;


import com.m4u.estude.dto.UserDTO;
import com.m4u.estude.model.User;
import com.m4u.estude.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> save(@RequestBody UserDTO dto){
        User user = userService.save(dto.userDto());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public String teste(){
        return "usuário";
    }








}
