package com.attornatus.peoplemanagement.peoplemanagement.application.useCases;

import com.attornatus.peoplemanagement.peoplemanagement.application.commands.UpdateAddresCommand;
import com.attornatus.peoplemanagement.peoplemanagement.infrastructure.entity.AddressEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class UpdatedAddressUseCase {

    public UpdateAddresCommand command;

    public UpdatedAddressUseCase(UpdateAddresCommand command) {
        this.command = command;
    }

    @Transactional
    public AddressEntity update() {
        UUID peopleId = command.address.getPeople().getId();

        command.addressRepository.setAllAsNotPrincipalByPeopleId(peopleId);
        command.address.setIsPrincipal(command.isPrincipal);

        return command.addressRepository.save(command.address);

    }
}
