package com.attornatus.peoplemanagement.peoplemanagement.infra.repository;

import com.attornatus.peoplemanagement.peoplemanagement.infra.entity.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;
@Repository
public interface PeopleRepository extends JpaRepository<PeopleEntity, UUID>{
    @Query(
        value = "SELECT * FROM people",
        nativeQuery = true
    )
    Collection<PeopleEntity> getAllPeoples();
}