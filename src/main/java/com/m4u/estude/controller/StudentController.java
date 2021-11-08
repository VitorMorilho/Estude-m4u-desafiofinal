package com.m4u.estude.controller;

import com.m4u.estude.dto.student.StudentPostRequestBody;
import com.m4u.estude.model.Student;
import com.m4u.estude.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> save(@Valid @RequestBody StudentPostRequestBody studentPostRequestBody){
        return new ResponseEntity<>( studentService.save(studentPostRequestBody), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> listAll() {
        return ResponseEntity.ok(studentService.listAllNonPageable());
    }
}
