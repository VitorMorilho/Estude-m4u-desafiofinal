package com.m4u.estude.controller;

import com.m4u.estude.dto.AddressDTO;
import com.m4u.estude.model.Address;
import com.m4u.estude.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("/address")
        public ResponseEntity<Address> save(@RequestBody AddressDTO dto){
            Address address = addressService.save(dto.addressDto());
            return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @GetMapping("/address")
    public String teste() {
        return "endereço";
    }

}
