package com.m4u.estude.controller;

import com.m4u.estude.model.Student;
import com.m4u.estude.model.User;
import com.m4u.estude.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController {
    private StudentRepository repository;

    @GetMapping("/login")
    public String index(){

        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, User userParam){
        User userAdm = this.repository.Login(userParam.getUsername(), userParam.getPassword());
        if (userAdm != null){
            return "redirect:/administrators";
        }
        model.addAttribute("Erro", "User invalid");
        return "login/index";
    }
}