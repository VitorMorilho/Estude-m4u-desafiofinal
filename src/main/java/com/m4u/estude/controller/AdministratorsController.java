package com.m4u.estude.controller;

import com.m4u.estude.model.Address;
import com.m4u.estude.model.Student;
import com.m4u.estude.model.User;
import com.m4u.estude.repository.StudentRepository;
import com.m4u.estude.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AdministratorsController {

    @Autowired
    public StudentRepository repo;
    @Autowired
    public UserRepository userRepo;

    @GetMapping("/administrators")
    public String index(Model model){
        List<Student> students = repo.findAll();
        System.out.println(students);
        model.addAttribute("students", students);
        return "administrators/index";
    }
//direciona o botão da adm para o formulario de cadastro
    @GetMapping("/administrators/signup")
    public String novo(){
        return "administrators/signup";
    }

    //Salva os dados do formulário
    @PostMapping("/administrators/criar")
    public String criar(User user ) {
        userRepo.save(user);
        return "redirect:/administrators"; //vai enviar para a lista
    }

    //Vai excluir o estudante ao apertar o botão
    @GetMapping("/administrators/{id}/excluir")
    public String excluir(@PathVariable long id){
        repo.deleteById(id);
        return "redirect:/administrators";
    }
}


















