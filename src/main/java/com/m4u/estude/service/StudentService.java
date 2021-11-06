package com.m4u.estude.service;

import com.m4u.estude.model.Student;
import com.m4u.estude.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student save(Student student){
        Optional<Student> student1 = studentRepository.findByEmail(student.getEmail());
        if(student1.isPresent()){

        }

        return studentRepository.save(student);
    }


}
