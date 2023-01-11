package com.attornatus.peoplemanagement.peoplemanagement.infra.Entity;

import com.attornatus.peoplemanagement.peoplemanagement.domain.Address;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "people")
public class PeopleEntity {
    @Id
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @OneToMany(mappedBy = "people")
    private List<Addresses> addresses;
}
