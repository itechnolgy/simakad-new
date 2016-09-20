package com.simakad.cms.config;

import com.simakad.dao.repo.NewStudentDao;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by HighDream on 9/11/2016.
 */
@Configuration
@EnableWebMvc
@EnableJpaRepositories(basePackageClasses = NewStudentDao.class)
@PropertySource("classpath:/application-dev.properties")
public class DatabaseConfig {
    private static final String ENTITY_PACKAGE_SCAN = "com.simakad.dao";
    protected static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    protected static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    protected static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    protected static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
    private static final String PROPERTY_NAME_DBCP_MAX_POOL_SIZE = "dbcp2.maxPoolSize";
    private static final String PROPERTY_NAME_DBCP_MIN_POOL_SIZE = "dbcp2.minPoolSize";

    @Autowired
    Environment env;

    /* DataSource definition for database connection */

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
        dataSource.setMaxTotal(Integer.parseInt(env.getRequiredProperty(PROPERTY_NAME_DBCP_MAX_POOL_SIZE)));
        dataSource.setMaxIdle(Integer.parseInt(env.getRequiredProperty(PROPERTY_NAME_DBCP_MAX_POOL_SIZE)));
        dataSource.setMinIdle(Integer.parseInt(env.getRequiredProperty(PROPERTY_NAME_DBCP_MIN_POOL_SIZE)));
        dataSource.setDefaultAutoCommit(false);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        Properties jpaProperties = new Properties();
        jpaProperties.put("eclipselink.jdbc.native-sql", "true");
        jpaProperties.put("eclipselink.weaving", "static");

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan(ENTITY_PACKAGE_SCAN);
        entityManagerFactory.setJpaVendorAdapter(eclipseLinkVendorAdapater());
        entityManagerFactory.setPersistenceUnitName("simakadPU");
        entityManagerFactory.setJpaProperties(jpaProperties);

        return entityManagerFactory;
    }

    @Bean
    public JpaVendorAdapter eclipseLinkVendorAdapater() {
        EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
        vendorAdapter.setShowSql(false);
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setDatabasePlatform("org.eclipse.persistence.platform.database.PostgreSQLPlatform");
        return vendorAdapter;
    }

    /* Set transaction manager */
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
