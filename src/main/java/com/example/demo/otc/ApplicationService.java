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

    public OilTonnage calculateTonnage(double density, double volume,double temperature){
        double vcfApplicable = vcfService.getVcf(new BigDecimal(density),new BigDecimal(temperature)).doubleValue();
        var calculateTonnage = (volume * density * vcfApplicable);

        OilTonnage oilTonnage = new OilTonnage();
        oilTonnage.setVolume(volume);
        oilTonnage.setDensity(density);
        oilTonnage.setTemperature(temperature);
        oilTonnage.setVcf(vcfApplicable);
        oilTonnage.setTonnage(calculateTonnage);
        oilTonnage.setCreatedAt(LocalDateTime.now());
        storeResultToDB(volume,density,temperature,vcfApplicable,calculateTonnage);
        return oilTonnage;

    }

    private OilTonnage storeResultToDB(double volume, double density, double temprature, double vcf, double tonnage) {

        OilTonnage oilTonnage = new OilTonnage();
        oilTonnage.setVolume(volume);
        oilTonnage.setDensity(density);
        oilTonnage.setTemperature(temprature);
        oilTonnage.setVcf(vcf);
        oilTonnage.setTonnage(tonnage);
        oilTonnage.setCreatedAt(LocalDateTime.now());
        return tonnageRepository.save(oilTonnage);

    }

    Iterable<OilTonnage> getAllSavedTonnages(){
        return  tonnageRepository.findAll();
    }
}
