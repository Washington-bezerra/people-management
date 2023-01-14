package com.attornatus.peoplemanagement.peoplemanagement.infrastructure.repository;

import com.attornatus.peoplemanagement.peoplemanagement.infrastructure.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Repository
@Transactional
public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {
    List<AddressEntity> findByPeopleId(UUID peopleId);

    @Modifying
    @Query(
        value = "UPDATE address SET is_principal = false WHERE people_id = :peopleId",
        nativeQuery = true
    )
    void setAllAsNotPrincipalByPeopleId(UUID peopleId);
}
