package personal.ivan.textparseservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Configuration
public class DataSourceClass {
    @Bean(name = "hardcodeSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("ivan");
        dataSource.setPassword("ivan1");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/testbase");
        return dataSource;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.test")
    public DataSourceProperties testDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "testSource")
    public DataSource testDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        DataSourceProperties properties = testDataSourceProperties();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setUrl(properties.getUrl());
        return dataSource;
    }

}
