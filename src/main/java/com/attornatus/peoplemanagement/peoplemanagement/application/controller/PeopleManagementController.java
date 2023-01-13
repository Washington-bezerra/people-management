package com.attornatus.peoplemanagement.peoplemanagement.application.controller;

import com.attornatus.peoplemanagement.peoplemanagement.application.commands.CreatePeopleCommand;
import com.attornatus.peoplemanagement.peoplemanagement.application.useCases.CreatePeopleUseCase;
import com.attornatus.peoplemanagement.peoplemanagement.domain.Address;
import com.attornatus.peoplemanagement.peoplemanagement.domain.People;
import com.attornatus.peoplemanagement.peoplemanagement.infrastructure.entity.AddressEntity;
import com.attornatus.peoplemanagement.peoplemanagement.infrastructure.entity.PeopleEntity;
import com.attornatus.peoplemanagement.peoplemanagement.infrastructure.repository.AddressRepository;
import com.attornatus.peoplemanagement.peoplemanagement.infrastructure.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class PeopleManagementController {

    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/people")
    @ResponseStatus(code = HttpStatus.CREATED)
    public PeopleEntity createPeople(@RequestBody People people) throws Exception {
        CreatePeopleCommand command = new CreatePeopleCommand(people, peopleRepository, addressRepository);
        CreatePeopleUseCase peopleEntity = new CreatePeopleUseCase(command);

        return peopleEntity.createPeople();
    }

    @PutMapping("/people/{peopleId}/address")
    public AddressEntity createAddress(
        @RequestBody Address address,
        @PathVariable UUID peopleId
    ){
        var people = peopleRepository.findById(peopleId);
        var addressEntity = new AddressEntity(address, people);

        return addressRepository.save(addressEntity);
    }

    @GetMapping("/people")
    public Collection<PeopleEntity> getAllPeoples() {
        return peopleRepository.getAllPeoples();
    }

    @GetMapping("/people/{id}")
    public Optional<PeopleEntity> getPeople(@PathVariable UUID id) {
        return peopleRepository.findById(id);
    }

    @GetMapping("/people/{peopleId}/address")
    public List<AddressEntity> getAllAddressByPeopleId(
            @PathVariable UUID peopleId
    ){
        return addressRepository.findByPeopleId(peopleId);
    }
    @PutMapping("/people/address/{addressId}")
    public ResponseEntity<Object> setAddress(
            @PathVariable UUID addressId,
            @RequestParam Boolean isPrincipal
    ){
        var address = addressRepository.findById(addressId).orElse(null);
        if (address == null){
            return new ResponseEntity<>("Address not found for id " + addressId, HttpStatus.NOT_FOUND);
        }
        address.setIsPrincipal(isPrincipal);
        address = addressRepository.save(address);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
