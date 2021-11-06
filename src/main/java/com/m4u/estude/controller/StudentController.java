package com.m4u.estude.controller;

import com.m4u.estude.dto.StudentDTO;
import com.m4u.estude.model.Student;
import com.m4u.estude.repository.StudentRepository;
import com.m4u.estude.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> save(@Valid @RequestBody Student student){
        return new ResponseEntity<>( studentService.save(student), HttpStatus.CREATED);

    }
    @GetMapping
    public String student(){
        return "Ola";
    }

}
