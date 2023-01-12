package com.attornatus.peoplemanagement.peoplemanagement.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class People{
    private UUID id = UUID.randomUUID();
    private String name;
    private Date birthDate;
    private List<Address> address;

    public People(){}

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
