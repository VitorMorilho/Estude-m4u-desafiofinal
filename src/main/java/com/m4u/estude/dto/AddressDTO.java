package com.m4u.estude.dto;

import com.m4u.estude.model.Address;
import lombok.Getter;

@Getter
public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private Integer zipCode;
}

//public Address addressDto(){
//    return new Address(street, city, state, zipCode);
//}
