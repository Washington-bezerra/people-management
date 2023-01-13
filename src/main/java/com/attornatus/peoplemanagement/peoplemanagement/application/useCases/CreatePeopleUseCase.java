package com.attornatus.peoplemanagement.peoplemanagement.application.useCases;

import com.attornatus.peoplemanagement.peoplemanagement.application.commands.CreatePeopleCommand;
import com.attornatus.peoplemanagement.peoplemanagement.domain.Address;
import com.attornatus.peoplemanagement.peoplemanagement.infrastructure.entity.AddressEntity;
import com.attornatus.peoplemanagement.peoplemanagement.infrastructure.entity.PeopleEntity;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class CreatePeopleUseCase {
    private CreatePeopleCommand command;

    public CreatePeopleUseCase(CreatePeopleCommand command) {
        this.command = command;
    }

    public PeopleEntity createPeople() throws Exception {

        final PeopleEntity peopleEntity = new PeopleEntity(
            command.people.getId(),
            command.people.getName(),
            command.people.getBirthDate()
        );

        var addresses = command.people.getAddress();

        List<AddressEntity> addressEntities = new ArrayList<>();
        int countPrincipalAddress = 0;
        for(Address address : addresses){
            if (address.getIsPrincipal()){countPrincipalAddress++;}
            if (countPrincipalAddress > 1){throw new Exception("Just one address can be the principal");}

            addressEntities.add(new AddressEntity(address, peopleEntity));
        }
        var peoplePersisted = command.peopleRepository.save(peopleEntity);
        command.addressRepository.saveAll(addressEntities);
        peoplePersisted.setAddress(addressEntities);

        return peoplePersisted;

    }

}
