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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

        PageImpl<Student> studentPage = new PageImpl<>(List.of(StudentCreator.createStudent()));
        BDDMockito.when(studentServiceMock.findAll(ArgumentMatchers.any()))
                .thenReturn(studentPage);

        BDDMockito.when(studentServiceMock.findByIdOrThrowBadRequestException(ArgumentMatchers.anyLong()))
                .thenReturn(StudentCreator.createStudent());

        BDDMockito.when(studentServiceMock.findByName(ArgumentMatchers.anyString()))
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
    @DisplayName("FindAll returns list of students inside page object when successful")
    void findAll_ReturnsListOfStudentInsidePageObject_WhenSuccessful() {
        String expectedName = StudentCreator.createStudent().getName();
        Page<Student> studentPage = studentController.find(null).getBody();

        Assertions.assertThat(studentPage).isNotNull();
        Assertions.assertThat(studentPage.toList()).isNotEmpty().hasSize(1);
        Assertions.assertThat(studentPage.toList().get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("findById return student when successful")
    void findById_ReturnStudent_WhenSuccessful() {
        Long expectedID = StudentCreator.createStudent().getId();

        Student student = studentController.findById(1).getBody();

        Assertions.assertThat(student).isNotNull();
        Assertions.assertThat(student.getId()).isEqualTo(expectedID);
    }

    @Test
    @DisplayName("findByName returns list of students when successful")
    void findByName_ReturnsListOfStudents_WhenSuccessful() {
        String expectedName = StudentCreator.createStudent().getName();

        List<Student> students = studentController.findByName("any_name").getBody();

        Assertions.assertThat(students).isNotEmpty().hasSize(1);
        Assertions.assertThat(students.get(0).getName()).isEqualTo(expectedName);
    }
}