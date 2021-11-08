package com.m4u.estude.service;

import com.m4u.estude.dto.student.StudentPostRequestBody;
import com.m4u.estude.model.Student;
import com.m4u.estude.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student save(StudentPostRequestBody studentPostRequestBody){
        Student student = Student.builder()
                .name(studentPostRequestBody.getName())
                .email(studentPostRequestBody.getEmail())
                .age(studentPostRequestBody.getAge())
                .build();
        return studentRepository.save(student);
    }

    public List<Student> listAllNonPageable() {
        return studentRepository.findAll();
    }
}

