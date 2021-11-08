package com.m4u.estude.controller;

import com.m4u.estude.dto.student.StudentPostRequestBody;
import com.m4u.estude.dto.student.StudentPutRequestBody;
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

    @GetMapping(path = "/find")
    public ResponseEntity<List<Student>> findByName(@RequestParam(required = false) String name) {
        return ResponseEntity.ok(studentService.findByName(name));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid StudentPutRequestBody studentPutRequestBody) {
        studentService.update(studentPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
