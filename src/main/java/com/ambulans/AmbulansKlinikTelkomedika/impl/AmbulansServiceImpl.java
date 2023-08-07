package com.ambulans.AmbulansKlinikTelkomedika.impl;

import com.ambulans.AmbulansKlinikTelkomedika.DTO.AmbulansDTO;
import com.ambulans.AmbulansKlinikTelkomedika.entity.AmbulansEntity;
import com.ambulans.AmbulansKlinikTelkomedika.repository.AmbulansRepository;
import com.ambulans.AmbulansKlinikTelkomedika.service.AmbulansService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AmbulansServiceImpl implements AmbulansService {

    private final AmbulansRepository ambulansRepository;

    public AmbulansServiceImpl(AmbulansRepository ambulansRepository) {
        this.ambulansRepository = ambulansRepository;
    }

    @Override
    public List<AmbulansEntity> findAllAmbulans() {
        return ambulansRepository.findAll();
    }

    @Override
    public Optional<AmbulansEntity> findById(Long id) {
        return ambulansRepository.findById(id);
    }

    @Override
    public AmbulansEntity saveAmbulans(AmbulansEntity ambulansEntity) {
        return ambulansRepository.save(ambulansEntity);
    }

    @Override
    public AmbulansEntity updateAmbulans(Long id, AmbulansDTO dto) {
        AmbulansEntity entity = ambulansRepository.findById(id).orElse(null);
        if(dto.supir() != null){
            entity.setSupir(dto.supir());
        }if(dto.tipe() != null){
            entity.setTipe(dto.tipe());
        }if(dto.platnomor() != null){
            entity.setPlatnomor(dto.platnomor());
        }
        return ambulansRepository.save(entity);
    }

    @Override
    public void deleteAmbulans(Long id) {
        ambulansRepository.deleteById(id);


    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public AmbulansDTO mapToDTO(AmbulansEntity ambulansEntity) {
        return mapper.convertValue(ambulansEntity, AmbulansDTO.class);
    }

    @Override
    public AmbulansEntity mapToEntity(AmbulansDTO ambulansDTO) {
        return mapper.convertValue(ambulansDTO, AmbulansEntity.class);
    }
    @Override
    public List<String> getRevision(Long id){
        return ambulansRepository.findRevisions(id).stream().map(Object::toString).collect(Collectors.toList());
    }
}
