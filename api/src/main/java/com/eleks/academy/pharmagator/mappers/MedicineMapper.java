package com.eleks.academy.pharmagator.mappers;

import com.eleks.academy.pharmagator.dataproviders.dto.MedicineDto;
import com.eleks.academy.pharmagator.entities.Medicine;
import com.eleks.academy.pharmagator.entities.Price;

public class MedicineMapper {

    public static Medicine DtoToMedicineEntity(MedicineDto dto) {
        Medicine medicine = new Medicine();
        medicine.setTitle(dto.getTitle());
        return medicine;
    }
    public static Price DtoToPriceEntity(MedicineDto dto)
    {
        Price price = new Price();
        price.setPrice(dto.getPrice());
        price.setExternalId(dto.getExternalId());
        return price;
    }
}
