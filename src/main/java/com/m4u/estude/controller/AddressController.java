package com.m4u.estude.controller;

import com.m4u.estude.dto.AddressDTO;
import com.m4u.estude.model.Address;
import com.m4u.estude.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping
        public ResponseEntity<Address> save(@RequestBody AddressDTO dto){
            Address address = addressService.save(dto.addressDto());
            return new ResponseEntity<>(address, HttpStatus.CREATED);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Address> findById(@PathVariable Integer id){
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Address> update(@PathVariable Integer id, @RequestBody AddressDTO dto){
        Address address = addressService.update(id, dto.addressDto());
        return new ResponseEntity(address, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        addressService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping
    public String teste() {
        return "endereço";
    }

}
