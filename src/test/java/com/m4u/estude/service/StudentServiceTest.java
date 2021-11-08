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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

        PageImpl<Student> studentPage = new PageImpl<>(List.of(StudentCreator.createStudent()));
        BDDMockito.when(studentRepositoryMock.findAll(ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(studentPage);

        BDDMockito.when(studentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(StudentCreator.createStudent()));

        BDDMockito.when(studentRepositoryMock.findByName(ArgumentMatchers.anyString()))
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
    @DisplayName("FindAll returns list of students inside page object when successful")
    void findAll_ReturnsListOfStudentInsidePageObject_WhenSuccessful() {
        String expectedName = StudentCreator.createStudent().getName();
        Page<Student> studentPage = studentService.findAll(PageRequest.of(1,1));

        Assertions.assertThat(studentPage).isNotNull();
        Assertions.assertThat(studentPage.toList()).isNotEmpty().hasSize(1);
        Assertions.assertThat(studentPage.toList().get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("findByIdOrThrowBadRequestException return student when successful")
    void findByIdOrThrowBadRequestException_ReturnStudent_WhenSuccessful() {
        Long expectedID = StudentCreator.createStudent().getId();

        Student student = studentService.findByIdOrThrowBadRequestException(1);

        Assertions.assertThat(student).isNotNull();
        Assertions.assertThat(student.getId()).isEqualTo(expectedID);
    }

    @Test
    @DisplayName("findByName returns list of students when successful")
    void findByName_ReturnsListOfStudents_WhenSuccessful() {
        String expectedName = StudentCreator.createStudent().getName();

        List<Student> students = studentService.findByName("any_name");

        Assertions.assertThat(students).isNotEmpty().hasSize(1);
        Assertions.assertThat(students.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("findByName returns an empty list when student is not found")
    void findByName_ReturnsEmptyList_WhenStudentIsNotFound() {
        BDDMockito.when(studentRepositoryMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(Collections.emptyList());

        String expectedName = StudentCreator.createStudent().getName();
        List<Student> students = studentService.findByName("");

        Assertions.assertThat(students).isNotNull().isEmpty();
    }
}