package com.example.demo.otc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VcfTable {
    private Long id;
    private BigDecimal density;
    private BigDecimal temperature;
    private BigDecimal vcf;
    private String oilClass;
    private BigDecimal vcf2;
}
