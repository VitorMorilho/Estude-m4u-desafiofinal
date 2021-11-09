package com.m4u.estude.repository;

import com.m4u.estude.model.Student;
import com.m4u.estude.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);

    //para verificar o login
    @Query(value="select * from user where email = :email and password = :password", nativeQuery = true)
    public User Login(String email, String password);

}

