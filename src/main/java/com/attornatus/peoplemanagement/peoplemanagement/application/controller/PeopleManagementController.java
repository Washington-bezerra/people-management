package com.attornatus.peoplemanagement.peoplemanagement.application.controller;

import com.attornatus.peoplemanagement.peoplemanagement.domain.Address;
import com.attornatus.peoplemanagement.peoplemanagement.domain.People;
import com.attornatus.peoplemanagement.peoplemanagement.infra.entity.AddressEntity;
import com.attornatus.peoplemanagement.peoplemanagement.infra.entity.PeopleEntity;
import com.attornatus.peoplemanagement.peoplemanagement.infra.repository.AddressRepository;
import com.attornatus.peoplemanagement.peoplemanagement.infra.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class PeopleManagementController {

    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/people")
    public PeopleEntity createPeople(@RequestBody People people){

        var peopleEntity = new PeopleEntity(people.getName(), people.getBirthDate());

        List<AddressEntity> addressEntities = new ArrayList<>();
        for (Address address : people.getAddress()) {
            AddressEntity addressEntity = new AddressEntity(address, peopleEntity);
            addressEntities.add(addressEntity);
        }

        peopleEntity = peopleRepository.save(peopleEntity);
        addressRepository.saveAll(addressEntities);
        peopleEntity.setAddress(addressEntities);

        return peopleEntity;
    }
}
