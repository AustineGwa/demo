package com.example.demo.otc.models;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OilTonnage {
    private Long id;
    private double volume;
    private double density;
    private double temperature;
    private double vcf;
    private double tonnage;
    private LocalDateTime createdAt;
}
