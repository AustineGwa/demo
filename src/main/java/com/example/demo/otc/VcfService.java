package com.example.demo.otc;

import com.example.demo.VcfRepository;
import com.example.demo.otc.models.VcfTable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
public class VcfService {


    private final VcfRepository vcfRepository;

    public VcfService(VcfRepository vcfRepository) {
        this.vcfRepository = vcfRepository;
    }

    /**
     * Get VCF for given density and temperature for rounded off values
     */
    public BigDecimal getVcf(BigDecimal density, BigDecimal temperature) {

        // Round density to nearest 0.5 and temperature to nearest 0.25
        BigDecimal roundedDensity = roundToNearest(density, new BigDecimal("0.5"));
        BigDecimal roundedTemperature = roundToNearest(temperature, new BigDecimal("0.25"));

        Optional<VcfTable> roundedMatch = vcfRepository.findByRoundedDensityAndTemperature(roundedDensity, roundedTemperature);
        if (roundedMatch.isPresent()) {
            return roundedMatch.get().getVcf();
        }

        return null;
    }

    /**
     * Round a BigDecimal to the nearest multiple of a given step
     */
    private BigDecimal roundToNearest(BigDecimal value, BigDecimal step) {
        return value.divide(step, 0, RoundingMode.HALF_UP).multiply(step);
    }

//    /**
//     * Validate if density is within acceptable range
//     */
//    public boolean isValidDensity(BigDecimal density) {
//        return density != null &&
//                density.compareTo(new BigDecimal("800")) >= 0 &&
//                density.compareTo(new BigDecimal("1000")) <= 0;
//    }
//
//    /**
//     * Validate if temperature is within acceptable range
//     */
//    public boolean isValidTemperature(BigDecimal temperature) {
//        return temperature != null &&
//                temperature.compareTo(new BigDecimal("-10")) >= 0 &&
//                temperature.compareTo(new BigDecimal("50")) <= 0;
//    }
}
