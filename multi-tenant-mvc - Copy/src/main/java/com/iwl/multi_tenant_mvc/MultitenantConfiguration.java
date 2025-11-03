package com.iwl.multi_tenant_mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.*;

@Configuration
public class MultitenantConfiguration {

    ///  this one is for getting tenant info from db

    @Value("${defaultTenant}")
    private String defaultTenant;

    // Inject the master DB properties
    @Value("${master.datasource.url}")
    private String masterUrl;
    @Value("${master.datasource.username}")
    private String masterUsername;
    @Value("${master.datasource.password}")
    private String masterPassword;
    @Value("${master.datasource.driver-class-name}")
    private String masterDriver;


    private static final String ENTITY_PACKAGE = "com.iwl.multi_tenant_mvc.domain";


    // 1. Create a bean to hold the tenant IDs
    private final List<String> tenantIds = new ArrayList<>();

    @Bean
    public List<String> tenantList() {
        return this.tenantIds;
    }

    // 2. This method creates the master DataSource (locally)
    private DataSource createMasterDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(masterDriver);
        dataSource.setUrl(masterUrl);
        dataSource.setUsername(masterUsername);
        dataSource.setPassword(masterPassword);
        return dataSource;
    }

    // 3. This is your main routing DataSource bean
    @Bean
    public DataSource dataSource() {
        // Create a temporary JDBC template to query the master DB
        JdbcTemplate masterJdbcTemplate = new JdbcTemplate(createMasterDataSource());

        Map<Object, Object> resolvedDataSources = new HashMap<>();

        // 4. Query the master DB for tenant configs
        List<Map<String, Object>> tenants = masterJdbcTemplate.queryForList("SELECT * FROM tenant_master");

        for (Map<String, Object> tenant : tenants) {
            String tenantId = (String) tenant.get("tenant_id");
            if(tenantId == null || tenantId == ""){
                continue;
            }
            System.out.println("Loading tenant: " + tenantId);

            // 5. Build each tenant's DataSource
//            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//            dataSourceBuilder.driverClassName("org.postgresql.Driver");
//            dataSourceBuilder.url((String) tenant.get("db_url"));
//            dataSourceBuilder.username((String) tenant.get("db_username"));
//            dataSourceBuilder.password((String) tenant.get("db_password"));

            DataSource ds = DataSourceBuilder.create()
                    .driverClassName("org.postgresql.Driver")
                    .url((String) tenant.get("db_url"))
                    .username((String) tenant.get("db_username"))
                    .password((String) tenant.get("db_password"))
                    .build();

            initializeTenantEntityManagerFactory(ds, tenantId);
            resolvedDataSources.put(tenantId, ds);

            // 6. Add the ID to our shared list
            this.tenantIds.add(tenantId);
        }

        // 7. Create the final routing DataSource
        AbstractRoutingDataSource dataSource = new MultitenantDataSource();
        dataSource.setDefaultTargetDataSource(resolvedDataSources.get(defaultTenant));
        dataSource.setTargetDataSources(resolvedDataSources);
        dataSource.afterPropertiesSet();
        return dataSource;
    }


    private void initializeTenantEntityManagerFactory(DataSource dataSource, String tenantId) {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(ENTITY_PACKAGE); // Where your @Entity classes are

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        // 1. Configure the Hibernate/JPA Properties
        Properties jpaProperties = new Properties();

        // Key setting: Set ddl-auto to 'update' or 'create' for the current tenant's DB
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");

        // Add other necessary properties
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        jpaProperties.put("hibernate.show_sql", "true"); // Optional

        em.setJpaProperties(jpaProperties);

        // 2. Initialize the Factory
        // This call is what triggers the schema creation/update process for this specific DataSource.
        em.afterPropertiesSet();

        System.out.println("Hibernate successfully initialized schema for tenant: " + tenantId);

        // NOTE: We don't need to return or hold onto this EM Factory,
        // we only needed its side-effect: schema creation.
    }


    //  this one is for getting tenant info from yml file

//    @Value("${defaultTenant}")
//    private String defaultTenant;
//    private final MultitenantProperties multitenantProperties;
//
//    // 1. Inject the properties class
//    public MultitenantConfiguration(MultitenantProperties multitenantProperties) {
//        this.multitenantProperties = multitenantProperties;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        Map<Object, Object> resolvedDataSources = new HashMap<>();
//
//        // 2. Iterate over the properties from the YAML
//        for (Map.Entry<String, DataSourceProperties> entry : multitenantProperties.getTenants().entrySet()) {
//            String tenantId = entry.getKey();
//            DataSourceProperties properties = entry.getValue();
//
//            System.out.println("Loading tenant: " + tenantId);
//
//            // 3. Use DataSourceBuilder to create the DataSource
//            DataSource ds = DataSourceBuilder.create()
//                    .driverClassName(properties.getDriverClassName())
//                    .url(properties.getUrl())
//                    .username(properties.getUsername())
//                    .password(properties.getPassword())
//                    .build();
//
//            resolvedDataSources.put(tenantId, ds);
//        }
//
//        // 4. Configure the routing data source
//        AbstractRoutingDataSource dataSource = new MultitenantDataSource();
//        dataSource.setDefaultTargetDataSource(resolvedDataSources.get(defaultTenant));
//        dataSource.setTargetDataSources(resolvedDataSources);
//        dataSource.afterPropertiesSet();
//
//        return dataSource;
//    }
}
