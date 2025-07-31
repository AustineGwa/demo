package com.example.demo.otc;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ApplicationService {

    private final VcfService vcfService;

    public ApplicationService(VcfService vcfService) {
        this.vcfService = vcfService;
    }

    public void calculateTonnage(double density, double volume,double temperature){
        double vcfApplicable = vcfService.getVcf(new BigDecimal(density),new BigDecimal(temperature)).doubleValue();
        var calculateTonnage = (volume * density * vcfApplicable);
        System.out.println("Calculated tonnage "+calculateTonnage);

    }
}
