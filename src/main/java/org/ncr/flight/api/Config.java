package org.ncr.flight.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration("ncr")
public class Config {

    @Value("${db.connection}")
    private String connection;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Value("${db.driver}")
    private String driver;

    @Bean
    public JdbcTemplate getNcrDb() {
        return new JdbcTemplate(getNcrDataSource());
    }

    @Bean
    public DataSource getNcrDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(connection);
        System.out.println("DB Connection: "+ connection);
        return ds;
    }
}
