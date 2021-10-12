package com.eleks.academy.pharmagator.mappers;

import com.eleks.academy.pharmagator.dataproviders.dto.PriceDto;
import com.eleks.academy.pharmagator.dataproviders.dto.PriceIdDto;
import com.eleks.academy.pharmagator.entities.Price;
import com.eleks.academy.pharmagator.entities.PriceId;

public class PriceMapper {
    public static Price DtoToEntity(PriceDto dto) {
        Price price = new Price();
        price.setPrice(dto.getPrice());
        price.setExternalId(dto.getExternalId());
        price.setMedicineId(dto.getMedicineId());
        price.setPharmacyId(dto.getPharmacyId());
        price.setUpdatedAt(dto.getUpdatedAt());
        return price;
    }
    public  static PriceId DtoToEntity(PriceIdDto dto)
    {
        PriceId priceId = new PriceId();
        priceId.setMedicineId(dto.getMedicineId());
        priceId.setPharmacyId(dto.getPharmacyId());
        return priceId;
    }

}
