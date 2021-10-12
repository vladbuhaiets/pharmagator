package com.eleks.academy.pharmagator.controllers;

import com.eleks.academy.pharmagator.dataproviders.dto.PharmacyDto;
import com.eleks.academy.pharmagator.entities.Pharmacy;
import com.eleks.academy.pharmagator.mappers.PharmacyMapper;
import com.eleks.academy.pharmagator.repositories.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pharmacies")
public class PharmacyController {
    private final PharmacyRepository pharmacyRepository;

    @GetMapping
    public ResponseEntity<List<Pharmacy>> getAll() {
        return ResponseEntity.ok(pharmacyRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pharmacy> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pharmacyRepository.getById(id));
    }

    @PostMapping("/createPharmacy")
    public ResponseEntity<Pharmacy> createPharmacy(@RequestBody PharmacyDto pharmacyDto) {
        return ResponseEntity.ok(pharmacyRepository.save(PharmacyMapper.DtoToEntity(pharmacyDto)));
    }

    @PutMapping("/updatePharmacy/{id}")
    public ResponseEntity<Pharmacy> updatePharmacy(@RequestBody PharmacyDto pharmacyDto, @PathVariable Long id) {
        Pharmacy newPharmacy = pharmacyRepository.findById(id).orElse(new Pharmacy());
        if (newPharmacy.getId() != id)
            newPharmacy.setId(id);
        newPharmacy.setName(pharmacyDto.getName());
        newPharmacy.setMedicineLinkTemplate(pharmacyDto.getMedicineLinkTemplate());
        return ResponseEntity.ok(pharmacyRepository.save(newPharmacy));
    }

    @DeleteMapping("/deletePharmacy/{id}")
    public void deletePharmacyById(@PathVariable Long id) {
        pharmacyRepository.deleteById(id);
    }

}
