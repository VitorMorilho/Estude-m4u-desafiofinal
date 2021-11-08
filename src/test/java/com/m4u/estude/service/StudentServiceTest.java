package com.m4u.estude.service;

import com.m4u.estude.model.Student;
import com.m4u.estude.repository.StudentRepository;
import com.m4u.estude.util.StudentCreator;
import com.m4u.estude.util.StudentPostRequestBodyCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class StudentServiceTest {
    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepositoryMock;

    @BeforeEach
    void setUp() {
        BDDMockito.when(studentRepositoryMock.save(ArgumentMatchers.any(Student.class)))
                .thenReturn(StudentCreator.createStudent());
    }

    @Test
    @DisplayName("save return student when successful")
    void save_ReturnStudent_WhenSuccessful() {
        Student student = studentService
                .save(StudentPostRequestBodyCreator.createStudentPostRequestBody());

        Assertions.assertThat(student)
                .isNotNull()
                .isEqualTo(StudentCreator.createStudent());
    }
}