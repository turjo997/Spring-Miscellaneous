package com.iwl.multi_tenant.service;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
@RequiredArgsConstructor
public class TenantService {
    private final DataSource dataSource;

    public void createTenantSchema(String tenantId){
        try(Connection conn = dataSource.getConnection()){
            Statement statement = conn.createStatement();
            statement.execute("CREATE SCHEMA IF NOT EXISTS " + tenantId);
            Flyway flyway = Flyway
                    .configure()
                    .dataSource(dataSource)
                    .schemas(tenantId).locations("classpath:db/migration")
                    .load();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create schema for tenant " + tenantId , e);
        }
    }
}
