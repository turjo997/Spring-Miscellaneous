package com.iwl.multi_tenant.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.connections.spi.DatabaseConnectionInfo;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class SchemaMultiTenantConnectionProvider implements MultiTenantConnectionProvider {

    @Autowired
    private final DataSource dataSource;

    public SchemaMultiTenantConnectionProvider(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(Object tenantIdentifier) throws SQLException {
        String tenantId = (tenantIdentifier != null) ? tenantIdentifier.toString() : "public";
        Connection connection = getAnyConnection();
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("SET search_path TO " + sanitize(tenantId) + ", public");
        }
        return connection;
    }

    @Override
    public void releaseConnection(Object o, Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            // restore default
            stmt.execute("SET search_path TO public");
        } finally {
            connection.close();
        }
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public DatabaseConnectionInfo getDatabaseConnectionInfo(Dialect dialect) {
        return MultiTenantConnectionProvider.super.getDatabaseConnectionInfo(dialect);
    }

    // required boilerplate
    @Override public boolean isUnwrappableAs(Class unwrapType) { return false; }
    @Override public <T> T unwrap(Class<T> unwrapType) { return null; }

    private String sanitize(String schema) {
        // minimal safety - do better in production (validate against allowed list)
        return schema.replaceAll("[^a-zA-Z0-9_]", "");
    }
}
