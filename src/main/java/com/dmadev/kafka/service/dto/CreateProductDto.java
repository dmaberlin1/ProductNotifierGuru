package com.dmadev.kafka.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductDto {
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
