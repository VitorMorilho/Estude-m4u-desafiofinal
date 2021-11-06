package com.m4u.estude.service;

import com.m4u.estude.model.Address;
import com.m4u.estude.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    public Address save(Address address){

        return addressRepository.save(address);
    }
}
