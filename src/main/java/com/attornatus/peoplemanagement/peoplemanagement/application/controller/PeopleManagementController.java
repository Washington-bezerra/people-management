package com.attornatus.peoplemanagement.peoplemanagement.application.controller;

import com.attornatus.peoplemanagement.peoplemanagement.domain.People;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleManagementController {

    @PostMapping("/people")
    public People createPeople(@RequestBody People people){
        return new People(
                people.getName(),
                people.getBirthDate(),
                people.getAddresses()
        );
    }
}
