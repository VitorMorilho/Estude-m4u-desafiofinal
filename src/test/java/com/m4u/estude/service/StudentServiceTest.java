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

import java.util.List;

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

        BDDMockito.when(studentRepositoryMock.findAll())
                .thenReturn(List.of(StudentCreator.createStudent()));
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

    @Test
    @DisplayName("findAllNonPageable returns list of students when successful")
    void findAll_ReturnsListOfStudent_WhenSuccessful() {
        String expectedName = StudentCreator.createStudent().getName();

        List<Student> students = studentService.listAllNonPageable();

        Assertions.assertThat(students)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);
        Assertions.assertThat(students.get(0).getName()).isEqualTo(expectedName);
    }
}