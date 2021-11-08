package com.m4u.estude.controller;

import com.m4u.estude.dto.student.StudentPostRequestBody;
import com.m4u.estude.model.Student;
import com.m4u.estude.service.StudentService;
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
class StudentControllerTest {
    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentServiceMock;

    @BeforeEach
    void setUp() {
        BDDMockito.when(studentServiceMock.save(ArgumentMatchers.any(StudentPostRequestBody.class)))
                .thenReturn(StudentCreator.createStudent());
        BDDMockito.when(studentServiceMock.listAllNonPageable())
                .thenReturn(List.of(StudentCreator.createStudent()));
    }

    @Test
    @DisplayName("save return student when successful")
    void save_ReturnStudent_WhenSuccessful() {
        Student student = studentController
                .save(StudentPostRequestBodyCreator.createStudentPostRequestBody())
                .getBody();

        Assertions.assertThat(student)
                .isNotNull()
                .isEqualTo(StudentCreator.createStudent());
    }

    @Test
    @DisplayName("FindAll returns list of students when successful")
    void findAll_ReturnsListOfStudent_WhenSuccessful() {
        String expectedName = StudentCreator.createStudent().getName();

        List<Student> students = studentController.listAll().getBody();

        Assertions.assertThat(students)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);
        Assertions.assertThat(students.get(0).getName()).isEqualTo(expectedName);
    }
}