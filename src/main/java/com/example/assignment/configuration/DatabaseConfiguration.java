package com.example.assignment.configuration;

import com.example.assignment.util.DatabaseType;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Database Configuration.
 */
@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.master.url}")
    private String MASTER_DATABASE_URL;

    @Value("${spring.datasource.master.username}")
    private String MASTER_DATABASE_USERNAME;

    @Value("${spring.datasource.master.password}")
    private String MASTER_DATABASE_PASSWORD;

    @Value("${spring.datasource.master.driver-class-name}")
    private String MASTER_PROPERTY_NAME_DATABASE_DRIVER;

    @Value("${spring.datasource.slave.url}")
    private String SLAVE_DATABASE_URL;

    @Value("${spring.datasource.slave.username}")
    private String SLAVE_DATABASE_USERNAME;

    @Value("${spring.datasource.slave.password}")
    private String SLAVE_DATABASE_PASSWORD;

    @Value("${spring.datasource.slave.driver-class-name}")
    private String SLAVE_PROPERTY_NAME_DATABASE_DRIVER;

    /**
     * dataSource.
     *
     * @return DataSource
     */
    @Bean
    public DataSource dataSource() {
        RoutingDataSource routingDataSource = new RoutingDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseType.UPDATABLE, masterDataSource());
        targetDataSources.put(DatabaseType.READONLY, slaveDataSource());
        routingDataSource.setTargetDataSources(targetDataSources);

        routingDataSource.setDefaultTargetDataSource(masterDataSource());
        return routingDataSource;
    }

    /***
     * slaveDataSource.
     *
     * @return DataSource
     */
    public DataSource slaveDataSource() {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(SLAVE_DATABASE_URL);
        hikariDataSource.setUsername(SLAVE_DATABASE_USERNAME);
        hikariDataSource.setPassword(SLAVE_DATABASE_PASSWORD);
        return hikariDataSource;
    }

    /***
     * masterDataSource.
     *
     * @return DataSource
     */
    public DataSource masterDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(MASTER_DATABASE_URL);
        hikariDataSource.setUsername(MASTER_DATABASE_USERNAME);
        hikariDataSource.setPassword(MASTER_DATABASE_PASSWORD);
        return hikariDataSource;
    }
}
