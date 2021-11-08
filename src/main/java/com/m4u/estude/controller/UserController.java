package com.m4u.estude.controller;


import com.m4u.estude.dto.UserDTO;
import com.m4u.estude.model.User;
import com.m4u.estude.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping
        public ResponseEntity<User> save(@RequestBody UserDTO userDTO){
            return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User>findById(@PathVariable Integer id){
      return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<User>update(@PathVariable Integer id, @RequestBody UserDTO dto){
        User user = userService.update(id, dto.userDto());
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Integer id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping
    public String teste(){
        return "usuário";
    }








}


