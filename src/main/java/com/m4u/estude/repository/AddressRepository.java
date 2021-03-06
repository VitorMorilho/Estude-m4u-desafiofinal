package com.m4u.estude.repository;

import com.m4u.estude.model.Address;
import com.m4u.estude.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
