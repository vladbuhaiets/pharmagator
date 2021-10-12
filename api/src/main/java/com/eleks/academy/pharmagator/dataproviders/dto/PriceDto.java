package com.eleks.academy.pharmagator.dataproviders.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class PriceDto {
    private long pharmacyId;
    private long medicineId;
    private BigDecimal price;
    private String externalId;
    private Instant updatedAt;
}
