package com.example.demo;

import com.example.demo.otc.models.VcfTable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

public interface VcfRepository extends CrudRepository<VcfTable, Long> {

    /**
     * Find VCF with density rounded to nearest 0.5 and temperature rounded to nearest 0.25
     */
    @Query("""
        SELECT * FROM table60b 
        WHERE density = ROUND(:density * 2, 0) / 2 
        AND temperature = ROUND(:temperature * 4, 0) / 4 
        LIMIT 1
        """)
    Optional<VcfTable> findByRoundedDensityAndTemperature(@Param("density") BigDecimal density, @Param("temperature") BigDecimal temperature);
}
