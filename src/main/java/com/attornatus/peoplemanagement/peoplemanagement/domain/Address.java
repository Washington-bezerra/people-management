package com.attornatus.peoplemanagement.peoplemanagement.domain;

import java.util.UUID;

public class Address {
    
    private UUID id = UUID.randomUUID();
    private String publicPlace;
    private int zipCode;
    private int number;
    private String city;

    public Address(String publicPlace, int zipCode, int number, String city) {
        this.publicPlace = publicPlace;
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
    }


}
