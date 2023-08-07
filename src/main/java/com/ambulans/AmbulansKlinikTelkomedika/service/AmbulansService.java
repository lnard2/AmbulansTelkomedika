package com.ambulans.AmbulansKlinikTelkomedika.service;

import com.ambulans.AmbulansKlinikTelkomedika.DTO.AmbulansDTO;
import com.ambulans.AmbulansKlinikTelkomedika.entity.AmbulansEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AmbulansService {
    List<AmbulansEntity> findAllAmbulans();
    Optional<AmbulansEntity> findById(Long id);
    AmbulansEntity saveAmbulans(AmbulansEntity ambulansEntity);
    AmbulansEntity updateAmbulans(Long id, AmbulansDTO dto);
    AmbulansDTO mapToDTO(AmbulansEntity ambulansEntity);
    AmbulansEntity mapToEntity(AmbulansDTO ambulansDTO);
    void deleteAmbulans(Long id);
    List<String> getRevision(Long id);
}
