package com.attornatus.peoplemanagement.peoplemanagement.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class People{
    private UUID id = UUID.randomUUID();
    private String name;
    private Date birthDate;
    private List<Address> addresses;

    public People(){}
    public People(String name, Date birthDate, List addresses) {
        this.name = name;
        this.birthDate = birthDate;
        this.addresses = addresses;
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

    public List getAddresses() {
        return addresses;
    }

    public void setAddresses(List addresses) {
        this.addresses = addresses;
    }
}
