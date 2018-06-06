package ua.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ua.dropwizzard.ApplicationConfiguration;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ua")
public class PersistenceContext {

    @Autowired
    ApplicationConfiguration applicationConfiguration;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(applicationConfiguration.getDatasourceUrl());
        driverManagerDataSource.setUsername(applicationConfiguration.getDatasourceUserName());
        driverManagerDataSource.setPassword(applicationConfiguration.getDatasourcePassword());
        driverManagerDataSource.setDriverClassName(applicationConfiguration.getDatasourceDriver());
        return driverManagerDataSource;
    }
}
