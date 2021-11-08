package com.m4u.estude.controller;

import com.m4u.estude.dto.student.StudentPostRequestBody;
import com.m4u.estude.model.Student;
import com.m4u.estude.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<Page<Student>> find(Pageable pageable) {
        return ResponseEntity.ok(studentService.findAll(pageable));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> findById(@PathVariable long id) {
        return ResponseEntity.ok(studentService.findByIdOrThrowBadRequestException(id));
    }
}
