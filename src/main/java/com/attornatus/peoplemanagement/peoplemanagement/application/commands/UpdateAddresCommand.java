package com.attornatus.peoplemanagement.peoplemanagement.application.commands;

import com.attornatus.peoplemanagement.peoplemanagement.infrastructure.entity.AddressEntity;
import com.attornatus.peoplemanagement.peoplemanagement.infrastructure.repository.AddressRepository;

public class UpdateAddresCommand {

    public AddressEntity address;
    public Boolean isPrincipal;

    public AddressRepository addressRepository;

    public UpdateAddresCommand(AddressEntity address, Boolean isPrincipal, AddressRepository addressRepository) {
        this.address = address;
        this.isPrincipal = isPrincipal;
        this.addressRepository = addressRepository;
    }

}
