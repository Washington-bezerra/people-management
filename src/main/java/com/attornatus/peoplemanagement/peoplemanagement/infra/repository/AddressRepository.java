package com.attornatus.peoplemanagement.peoplemanagement.infra.repository;

import com.attornatus.peoplemanagement.peoplemanagement.infra.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
