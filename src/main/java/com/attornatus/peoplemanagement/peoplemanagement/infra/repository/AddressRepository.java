package com.attornatus.peoplemanagement.peoplemanagement.infra.repository;

import com.attornatus.peoplemanagement.peoplemanagement.infra.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {
    List<AddressEntity> findByPeopleId(UUID peopleId);

}
