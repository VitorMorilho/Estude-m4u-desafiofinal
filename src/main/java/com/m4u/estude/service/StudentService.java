package com.m4u.estude.service;

import com.m4u.estude.dto.student.StudentPostRequestBody;
import com.m4u.estude.dto.student.StudentPutRequestBody;
import com.m4u.estude.exception.badRequest.BadRequestException;
import com.m4u.estude.model.Student;
import com.m4u.estude.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Student findByIdOrThrowBadRequestException(long id) {
       return studentRepository.findById(id)
               .orElseThrow(() -> new BadRequestException("Student not found!"));
    }

    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    public void update(StudentPutRequestBody studentPutRequestBody) {
        Student savedStudent = findByIdOrThrowBadRequestException(studentPutRequestBody.getId());

        Student student = Student.builder()
                .id(savedStudent.getId())
                .name(studentPutRequestBody.getName())
                .email(studentPutRequestBody.getEmail())
                .age(studentPutRequestBody.getAge())
                .build();

        studentRepository.save(student);
    }
}

