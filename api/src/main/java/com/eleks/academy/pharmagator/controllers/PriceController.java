package com.eleks.academy.pharmagator.controllers;

import com.eleks.academy.pharmagator.dataproviders.dto.PriceDto;
import com.eleks.academy.pharmagator.dataproviders.dto.PriceIdDto;
import com.eleks.academy.pharmagator.entities.Price;
import com.eleks.academy.pharmagator.mappers.PriceMapper;
import com.eleks.academy.pharmagator.repositories.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("prices")
public class PriceController {
    private final PriceRepository priceRepository;

    @GetMapping
    private ResponseEntity<List<Price>> getAll() {
        return ResponseEntity.ok(priceRepository.findAll());
    }

    @GetMapping("/{pid}_{mid}")
    public ResponseEntity<Price> getById(@PathVariable Long pid,@PathVariable Long mid) {
        PriceIdDto priceIdDto = new PriceIdDto();
        priceIdDto.setPharmacyId(pid);
        priceIdDto.setMedicineId(mid);
        return ResponseEntity.ok(priceRepository.getById(PriceMapper.DtoToEntity(priceIdDto)));
    }

    @PostMapping("/createPrice")
    public ResponseEntity<Price> createPrice(@RequestBody PriceDto priceDto) {
        return ResponseEntity.ok(priceRepository.save(PriceMapper.DtoToEntity(priceDto)));
    }

    @PutMapping("/updatePrice/{pid}_{mid}")
    public ResponseEntity<Price> updatePrice(@RequestBody PriceDto priceDto, @PathVariable Long pid,@PathVariable Long mid) {
        PriceIdDto priceIdDto = new PriceIdDto();
        priceIdDto.setPharmacyId(pid);
        priceIdDto.setMedicineId(mid);
        Price newPrice = priceRepository.getById(PriceMapper.DtoToEntity(priceIdDto));
        newPrice.setPrice(priceDto.getPrice());
        newPrice.setUpdatedAt(priceDto.getUpdatedAt());
        newPrice.setExternalId(priceDto.getExternalId());
        return ResponseEntity.ok(priceRepository.save(newPrice));
    }

    @DeleteMapping("/deletePrice/{pid}_{mid}")
    public void deletePriceById(@PathVariable Long pid,@PathVariable Long mid) {
        PriceIdDto priceIdDto = new PriceIdDto();
        priceIdDto.setPharmacyId(pid);
        priceIdDto.setMedicineId(mid);
        priceRepository.deleteById(PriceMapper.DtoToEntity(priceIdDto));
    }
}
