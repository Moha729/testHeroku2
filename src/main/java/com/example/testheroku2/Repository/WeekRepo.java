package com.example.testheroku2.Repository;

import com.example.testheroku2.Model.WeekNumberWrapper;
import com.example.testheroku2.Repository.Mapper.WeekMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WeekRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void updateWeek (int updatedWeek){
        int onlyWeek = beforeWeek();
        String sql = "UPDATE current_week SET now_week = ? WHERE now_week = ?";
        jdbcTemplate.update(sql, updatedWeek, onlyWeek);
    }

    public int beforeWeek() {
        String sql = "SELECT * FROM current_week";
//        BeanPropertyRowMapper<Integer> rowMapper = new BeanPropertyRowMapper<>(WeekNumberWrapper.class);
//        List<WeekNumberWrapper> weekGet = jdbcTemplate.query(sql, rowMapper);
//        int beforeWeek = weekGet.get(0).getWeekNumb();

        RowMapper rowMapper = new WeekMapper();
        List<WeekNumberWrapper> weekNumberWrappers = jdbcTemplate.query(sql, rowMapper);
        int beforeWeek = weekNumberWrappers.get(0).getWeekNumb();
        System.out.println("BEFORE WEEK "+ beforeWeek);
        return beforeWeek;
    }
}
