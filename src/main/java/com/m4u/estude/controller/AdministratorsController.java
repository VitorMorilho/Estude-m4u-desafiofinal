package com.m4u.estude.controller;

import com.m4u.estude.model.Student;
import com.m4u.estude.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdministratorsController {

    @Autowired
    public StudentRepository repo;

    @GetMapping("/administrators")
    public String index(Model model){
        List<Student> students = repo.findAll();
        System.out.println(students);
        model.addAttribute("students", students);
        return "administrators/index";
    }
}
