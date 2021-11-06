package com.m4u.estude.service;

import com.m4u.estude.model.User;
import com.m4u.estude.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User store(User user){
        return userRepository.save(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
