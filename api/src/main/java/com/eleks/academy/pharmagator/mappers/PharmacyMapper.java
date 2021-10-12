package com.eleks.academy.pharmagator.mappers;

import com.eleks.academy.pharmagator.dataproviders.dto.PharmacyDto;
import com.eleks.academy.pharmagator.entities.Pharmacy;

public class PharmacyMapper {
    public static Pharmacy DtoToEntity(PharmacyDto dto) {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setName(dto.getName());
        pharmacy.setMedicineLinkTemplate(dto.getMedicineLinkTemplate());
        return pharmacy;
    }

    public static PharmacyDto EntityToDto(Pharmacy pharmacy) {
        PharmacyDto dto = new PharmacyDto();
        dto.setName(pharmacy.getName());
        dto.setMedicineLinkTemplate(pharmacy.getMedicineLinkTemplate());
        return dto;
    }
}
