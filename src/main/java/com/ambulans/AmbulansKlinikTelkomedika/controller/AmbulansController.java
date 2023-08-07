package com.ambulans.AmbulansKlinikTelkomedika.controller;

import com.ambulans.AmbulansKlinikTelkomedika.DTO.AmbulansDTO;
import com.ambulans.AmbulansKlinikTelkomedika.entity.AmbulansEntity;
import com.ambulans.AmbulansKlinikTelkomedika.service.AmbulansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ambulans")
public class AmbulansController {
    @Autowired
    AmbulansService ambulansService;
    @GetMapping
    public List<AmbulansDTO> findAllAmbulans() {
        return ambulansService.findAllAmbulans().stream().map(ambulansEntity -> ambulansService.mapToDTO(ambulansEntity))
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public Optional<AmbulansEntity> findAmbulansById(@PathVariable("id") Long id) {
        return ambulansService.findById(id);
    }
    @PostMapping
    public AmbulansDTO saveAmbulans(@RequestBody AmbulansDTO request){
        final AmbulansEntity ambulansEntity = ambulansService.mapToEntity(request);
        final AmbulansEntity result = ambulansService.saveAmbulans(ambulansEntity);
        return ambulansService.mapToDTO(result);
    }
    @PutMapping("{id}")
    public AmbulansEntity updateAmbulans(@PathVariable("id") Long id, @RequestBody AmbulansDTO request){
//        final AmbulansEntity ambulansEntity = ambulansService.mapToEntity(request);
//        final AmbulansEntity result = ambulansService.updateAmbulans(ambulansEntity);

        return ambulansService.updateAmbulans(id, request);
    }
    @DeleteMapping("/{id}")
    public void deleteAmbulans(@PathVariable("id") Long id) {
        ambulansService.deleteAmbulans(id);
    }
    @GetMapping("/revision/{id}")
    public List<String> getRevision(@PathVariable("id") Long id){
        return ambulansService.getRevision(id);
    }
}