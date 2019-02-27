package org.ncr.flight.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class Debug {

    @Autowired
    private JdbcTemplate ncrDb;

    private RowMapper<Date> dateReader= new RowMapper<Date>() {
            public Date mapRow(ResultSet resultSet, int rowId) throws SQLException {
                return resultSet.getDate(1);
            }
        };

    @RequestMapping("/debug")
    @ResponseBody()
    public Object dothing() {
        Date now= ncrDb.query("select now()", dateReader).get(0);
        return "hello, it is now "+ now;
    }


}
