package com.eleks.academy.pharmagator.controllers;

import com.eleks.academy.pharmagator.dataproviders.dto.MedicineDto;
import com.eleks.academy.pharmagator.entities.Medicine;
import com.eleks.academy.pharmagator.mappers.MedicineMapper;
import com.eleks.academy.pharmagator.repositories.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/medicines")
public class MedicineController {
    private final MedicineRepository medicineRepository;

    @GetMapping
    private ResponseEntity<List<Medicine>> getAll() {
        return ResponseEntity.ok(medicineRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getById(@PathVariable Long id) {
        return ResponseEntity.ok(medicineRepository.getById(id));
    }

    @PostMapping("/createMedicine")
    public ResponseEntity<Medicine> createMedicine(@RequestBody MedicineDto medicineDto) {
        return ResponseEntity.ok(medicineRepository.save(MedicineMapper.DtoToMedicineEntity(medicineDto)));
    }

    @PutMapping("/updateMedicine/{id}")
    public ResponseEntity<Medicine> updateMedicine(@RequestBody MedicineDto medicineDto, @PathVariable Long id) {
        Medicine newMedicine = medicineRepository.findById(id).orElse(new Medicine());
        if (newMedicine.getId() != id)
            newMedicine.setId(id);
        newMedicine.setTitle(medicineDto.getTitle());
        return ResponseEntity.ok(medicineRepository.save(newMedicine));
    }

    @DeleteMapping("/deleteMedicine/{id}")
    public void deleteMedicineById(@PathVariable Long id) {
        medicineRepository.deleteById(id);
    }
}
