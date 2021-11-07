package com.m4u.estude.service;

import com.m4u.estude.model.User;
import com.m4u.estude.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Integer id){


        return userRepository.findById(id).stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Users not found"));
    }

    public void delete(Integer id){
        userRepository.delete(findById(id));
    }

    public User update(Integer id, User user){
        if (! userRepository.existsById(id)){
            return findById(id);
        }
        user.setId(id);
        return userRepository.save(user);
    }
}

//    public User store(User user){
//        return userRepository.save(user);
//    }