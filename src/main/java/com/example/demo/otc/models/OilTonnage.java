package com.example.demo.otc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OilTonnage {

    private Long id;
    private BigDecimal volume;
    private BigDecimal density;
    private BigDecimal temperature;
    private BigDecimal vcf;
    private BigDecimal tonnage;
    private LocalDateTime createdAt;
}
