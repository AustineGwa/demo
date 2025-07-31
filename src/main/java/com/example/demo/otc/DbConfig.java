package com.example.demo.otc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {


    String DB_USER= "root";
    String DB_PASS="";


    String DB_URL="127.0.0.1";

    @Bean
    public HikariConfig hikariConfig1() {
        HikariConfig config = new HikariConfig();
        config.setUsername(DB_USER);
        config.setPassword(DB_PASS);
        config.setJdbcUrl(DB_URL);
        return config;
    }

    @Bean
    @Primary
    public DataSource firstDataSource(HikariConfig hikariConfig1){return new HikariDataSource(hikariConfig1); }

    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("firstDataSource") DataSource ds){
        return new JdbcTemplate(ds);
    }

}

