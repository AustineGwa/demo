package com.example.demo.otc.models;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class vcfRepository {

    private final JdbcTemplate jdbcTemplate;

    public vcfRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
