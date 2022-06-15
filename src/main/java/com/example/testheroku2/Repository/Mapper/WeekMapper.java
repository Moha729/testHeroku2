package com.example.testheroku2.Repository.Mapper;

import com.example.testheroku2.Model.WeekNumberWrapper;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeekMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        WeekNumberWrapper weekNumberWrapper = new WeekNumberWrapper();
        weekNumberWrapper.setWeekNumb(rs.getInt("now_week"));

        return weekNumberWrapper;
    }
}
