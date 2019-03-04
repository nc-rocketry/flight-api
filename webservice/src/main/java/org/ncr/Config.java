package org.ncr;

import club.ncr.cayenne.Motor;
import club.ncr.motors.MotorDbCache;
import club.ncr.security.Crypto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.thrustcurve.TCApiClient;

import javax.sql.DataSource;

@Configuration
public class Config {

    private MotorDbCache motorCache= new MotorDbCache("cayenne-ncrclub.xml");

    @Value("${ncr.flight.db.connection}")
    private String flightConnection;

    @Value("${ncr.flight.db.username}")
    private String flightUsername;

    @Value("${ncr.flight.db.password}")
    private String flightPassword;

    @Value("${ncr.flight.db.driver}")
    private String flightDriver;

    @Value("${ncr.flight.db.encoded:false}")
    private Boolean flightEncoded;

    @Value("${ncr.records.db.connection}")
    private String recordsConnection;

    @Value("${ncr.records.db.username}")
    private String recordsUsername;

    @Value("${ncr.records.db.password}")
    private String recordsPassword;

    @Value("${ncr.records.db.driver}")
    private String recordsDriver;

    @Value("${ncr.records.db.encoded:false}")
    private Boolean recordsEncoded;

    @Bean
    public JdbcTemplate flightDb() {
        return new JdbcTemplate(flightDatasource());
    }

    @Bean
    public DataSource flightDatasource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(flightDriver);
        ds.setUsername(flightUsername);
        ds.setPassword(flightEncoded ? Crypto.decode(flightPassword) : flightPassword);
        ds.setUrl(flightConnection);
        return ds;
    }

    @Bean
    public JdbcTemplate recordsDb() {
        return new JdbcTemplate(recordsDataSource());
    }

    @Bean
    public DataSource recordsDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(recordsDriver);
        ds.setUsername(recordsUsername);
        ds.setPassword(recordsEncoded ? Crypto.decode(recordsPassword) : recordsPassword);
        ds.setUrl(recordsConnection);
        return ds;
    }

    @Bean
    public MotorDbCache motorCache() {
        return motorCache;
    }

    @Bean
    public TCApiClient client() {
        return new TCApiClient();
    }

}
