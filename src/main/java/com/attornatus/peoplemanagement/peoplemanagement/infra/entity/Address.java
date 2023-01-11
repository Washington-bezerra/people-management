package com.attornatus.peoplemanagement.peoplemanagement.infra.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "people_id")
    private People people;

    @Column(name = "public_place", nullable = false)
    private String publicPlace;

    @Column(name = "zip_code", nullable = false)
    private int zipCode;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "city", nullable = false)
    private String city;

}
