package com.example.testheroku2.Repository;

import com.example.testheroku2.Model.cleaning.CleaningArea;
import com.example.testheroku2.Repository.Mapper.CleaningAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class CleaningRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public ArrayList<CleaningArea> fetchAll() {
        String sql = "SELECT * FROM cleaning_areas";
        RowMapper<CleaningArea> rowMapper = new CleaningAreaMapper();
        return (ArrayList<CleaningArea>) jdbcTemplate.query(sql, rowMapper);
    }

    public void addNew(CleaningArea cleaningArea){
        String sql = "INSERT INTO cleaning_areas (index_no, area_def) VALUES (?,?)";
        jdbcTemplate.update(sql, cleaningArea.getSectionId(), cleaningArea.getSectionName());
    }

    public CleaningArea findById(int id){
        String sql = "SELECT * FROM cleaning_areas WHERE index_no = ?";
        RowMapper<CleaningArea> rowMapper = new CleaningAreaMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public void setAssigendTo(int id, CleaningArea section){
        String sql = "UPDATE cleaning_areas SET assigned_to = ? " +
                "WHERE index_no =?";
        jdbcTemplate.update(sql, section.getAssignedTo(),
        id);
    }


    public void setDoneBy(int id, CleaningArea section) {

//        Timestamp instant= Timestamp.from(Instant.now());
//
//        section.setCompletionDate(instant.toString());
//        System.out.println(section.getCompletionDate());

        //System.out.println(dateFormat.format(doneDateAndTime));

        String sql = "UPDATE cleaning_areas SET done_by = ?, done_date=? " +
                "WHERE index_no =?";
        jdbcTemplate.update(sql, section.getDoneBy(), section.getCompletionDate(),
                id);

    }

    public void setApproved(int id, CleaningArea section) {
        String sql = "UPDATE cleaning_areas SET done_status = ? WHERE index_no = ?";
        jdbcTemplate.update(sql, section.isApprovedStatus(),
                id);
    }
}
