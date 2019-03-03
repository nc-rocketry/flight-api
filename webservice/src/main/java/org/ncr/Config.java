package org.ncr;

import club.ncr.security.Crypto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Value("${ncr.db.connection}")
    private String connection;

    @Value("${ncr.db.username}")
    private String username;

    @Value("${ncr.db.password}")
    private String password;

    @Value("${ncr.db.driver}")
    private String driver;

    @Value("${ncr.db.encoded:false}")
    private Boolean encoded;


    @Bean
    public JdbcTemplate ncrDb() {
        return new JdbcTemplate(ncrDataSource());
    }

    @Bean
    public DataSource ncrDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUsername(username);
        System.out.println(" the password is "+ (encoded ? Crypto.decode(password) : password));
        ds.setPassword(encoded ? Crypto.decode(password) : password);
        ds.setUrl(connection);
        System.out.println("DB Connection: "+ connection);
        return ds;
    }
}
