package com.example.assignment.configuration;

import com.example.assignment.aop.DatabaseContext;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Routing Data Source.
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContext.getDatabaseType();
    }
}
