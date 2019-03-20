package com.example.springbooteventmanaging.configuration;
// Spring 5
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
 import javax.sql.DataSource;

@Configuration
//@Import ({DataBaseConig.class, WebConfig.class})
public class DataSourceConfig {
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/eventdatabase?serverTimezone=UTC")
                .username("root")
                .password("")
                .build();
    }
}