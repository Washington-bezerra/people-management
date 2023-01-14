package com.attornatus.peoplemanagement.peoplemanagement.application.commands;

import com.attornatus.peoplemanagement.peoplemanagement.domain.People;
import com.attornatus.peoplemanagement.peoplemanagement.infrastructure.repository.AddressRepository;
import com.attornatus.peoplemanagement.peoplemanagement.infrastructure.repository.PeopleRepository;

public class CreatePeopleCommand {
    public People people;
    public PeopleRepository peopleRepository;
    public AddressRepository addressRepository;

    public CreatePeopleCommand(
        People people,
        PeopleRepository peopleRepository,
        AddressRepository addressRepository
    ) {
        this.people = people;
        this.peopleRepository = peopleRepository;
        this.addressRepository = addressRepository;
    }
}
