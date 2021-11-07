package com.m4u.estude.service;

import com.m4u.estude.model.Address;
import com.m4u.estude.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    public Address save(Address address){

        return addressRepository.save(address);
    }

    public Address findById (Integer id){

        return addressRepository.findById(id).stream()
                .filter(address -> address.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Address not found"));
    }

    public void delete(Integer id) {
        addressRepository.delete(findById(id));
    }

    public Address update(Integer id, Address address) {
        if(!addressRepository.existsById(id)){
            return findById(id);
        }
        address.setId(id);
        return addressRepository.save(address);
    }
}
