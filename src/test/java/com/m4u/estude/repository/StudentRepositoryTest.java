package com.m4u.estude.repository;

import com.m4u.estude.model.Student;
import com.m4u.estude.util.StudentCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;
import java.util.List;

@DataJpaTest
@DisplayName("Tests for Students repository")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @DisplayName("Save persists student when successful")
    void save_PersistStudent_WhenSuccessful() {
        Student student = StudentCreator.createStudent();
        Student studentSaved = studentRepository.save(student);
        Assertions.assertThat(studentSaved).isNotNull();
        Assertions.assertThat(studentSaved.getId()).isNotNull();
        Assertions.assertThat(studentSaved.getName()).isEqualTo(studentSaved.getName());
    }

    @Test
    @DisplayName("findAll returns a list of students when successful")
    void findAll_ReturnsListOfStudents_WhenSuccessful() {
        Student student = StudentCreator.createStudent();
        Student studentSaved = this.studentRepository.save(student);

        List<Student> students = this.studentRepository.findAll();

        Assertions.assertThat(students)
                .isNotEmpty()
                .contains(studentSaved);
    }

//    @Test
//    @DisplayName("Save throw ConstraintViolationException when name is empty")
//    void save_throwConstraintViolationException_WhenNameIsEmpty(){
//        Student student = StudentCreator.createInvalidStudent("", "rvsantos@test.com", 7);
//        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
//                .isThrownBy(() -> this.studentRepository.save(student))
//                .withMessageContaining("The student name cannot be empty/null");
//    }
//
//    @Test
//    @DisplayName("Save throw ConstraintViolationException when email is empty")
//    void save_throwConstraintViolationException_WhenEmailIsEmpty(){
//        Student student = StudentCreator.createInvalidStudent("rafael", "", 7);
//        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
//                .isThrownBy(() -> this.studentRepository.save(student))
//                .withMessageContaining("The student email cannot be empty");
//    }
//
//    @Test
//    @DisplayName("Save throw ConstraintViolationException when age is less than 6")
//    void save_throwConstraintViolationException_WhenAgeIsLessThan6(){
//        Student student = StudentCreator.createInvalidStudent("rafael", "rvsantos@test.com", 3);
//        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
//                .isThrownBy(() -> this.studentRepository.save(student))
//                .withMessageContaining("Age must be at least 6");
//    }
}