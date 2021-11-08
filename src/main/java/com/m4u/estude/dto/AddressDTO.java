package com.m4u.estude.dto;

import com.m4u.estude.model.Address;
import lombok.Getter;

@Getter
public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private Integer zipCode;
    private String country;

    public Address addressDto(){
    return new Address(street, city, state, zipCode, country);
    }

}


