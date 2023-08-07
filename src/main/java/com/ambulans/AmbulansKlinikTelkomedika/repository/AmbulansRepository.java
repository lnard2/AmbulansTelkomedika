package com.ambulans.AmbulansKlinikTelkomedika.repository;

import com.ambulans.AmbulansKlinikTelkomedika.entity.AmbulansEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AmbulansRepository extends JpaRepository<AmbulansEntity, Long>, RevisionRepository<AmbulansEntity, Long, Long> {

}
