package personal.ivan.textparseservice;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Component
public class DataSourceClass {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("ivan");
        dataSource.setPassword("ivan");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/testbase");

        return dataSource;
    }
}
