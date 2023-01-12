package com.attornatus.peoplemanagement.peoplemanagement.domain;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class People{
    private UUID id;
    private String name;
    private Date birthDate;
    private List<Address> address;

    public People(){}

    public People(UUID id, String name, Date birthDate, List<Address> address){
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
