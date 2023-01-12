package com.attornatus.peoplemanagement.peoplemanagement.domain;

import java.util.UUID;

public class Address {
    
    private UUID id;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
