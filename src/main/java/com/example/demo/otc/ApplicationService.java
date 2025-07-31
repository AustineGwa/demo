package com.example.demo.otc;

import com.example.demo.otc.models.OilTonnage;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationService {

    private final VcfService vcfService;
    private final TonnageRepository tonnageRepository;

    public ApplicationService(VcfService vcfService, TonnageRepository tonnageRepository) {
        this.vcfService = vcfService;
        this.tonnageRepository = tonnageRepository;
    }

    public void calculateTonnage(double density, double volume,double temperature){
        double vcfApplicable = vcfService.getVcf(new BigDecimal(density),new BigDecimal(temperature)).doubleValue();
        var calculateTonnage = (volume * density * vcfApplicable);
        System.out.println("Calculated tonnage "+calculateTonnage);

        storeResultToDB(volume,density,temperature,vcfApplicable,calculateTonnage);

    }

    private OilTonnage storeResultToDB(double volume, double density, double temprature, double vcf, double tonnage) {

        OilTonnage oilTonnage = new OilTonnage();
        oilTonnage.setVolume(new BigDecimal(volume));
        oilTonnage.setDensity(new BigDecimal(density));
        oilTonnage.setTemperature(new BigDecimal(temprature));
        oilTonnage.setVcf(new BigDecimal(vcf));
        oilTonnage.setTonnage(new BigDecimal(tonnage));
        oilTonnage.setCreatedAt(LocalDateTime.now());
        return tonnageRepository.save(oilTonnage);

    }

    Iterable<OilTonnage> getAllSavedTonnages(){
        return  tonnageRepository.findAll();
    }
}
