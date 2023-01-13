package com.attornatus.peoplemanagement.peoplemanagement.infrastructure.entity;

import com.attornatus.peoplemanagement.peoplemanagement.domain.Address;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "address")
public class AddressEntity  implements Serializable {
    private static final long serialVersionUID = 1l;
    @Column
    @Id
    private UUID id;

    @JoinColumn(name = "people_id")
    @ManyToOne
    @JsonBackReference
    private PeopleEntity people;

    @Column(name = "public_place", nullable = false)
    private String publicPlace;

    @Column(name = "zip_code", nullable = false)
    private int zipCode;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "is_principal", nullable = false)
    private Boolean isPrincipal;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updated_at;

    public AddressEntity() {}

    public AddressEntity(Address address, PeopleEntity people) {
        this.id = address.getId();
        this.zipCode = address.getZipCode();
        this.publicPlace = address.getPublicPlace();
        this.city = address.getCity();
        this.number = address.getNumber();
        this.city = address.getCity();
        this.isPrincipal = address.getIsPrincipal();
        this.people = people;
    }

    public AddressEntity(Address address, Optional<PeopleEntity> people) {
        this.id = address.getId();
        this.zipCode = address.getZipCode();
        this.publicPlace = address.getPublicPlace();
        this.city = address.getCity();
        this.number = address.getNumber();
        this.city = address.getCity();
        this.isPrincipal = address.getIsPrincipal();
        this.people = people.get();
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public Boolean getIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(Boolean principal) {
        isPrincipal = principal;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PeopleEntity getPeople() {
        return people;
    }

    public void setPeople(PeopleEntity people) {
        this.people = people;
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
