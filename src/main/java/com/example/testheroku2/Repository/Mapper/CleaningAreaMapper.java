package com.example.testheroku2.Repository.Mapper;

import com.example.testheroku2.Model.cleaning.CleaningArea;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CleaningAreaMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        CleaningArea cleaningArea = new CleaningArea();

        cleaningArea.setSectionId(rs.getInt("index_no"));
        cleaningArea.setSectionName(rs.getString("area_def"));
        cleaningArea.setAssignedTo(rs.getString("assigned_to"));
        cleaningArea.setDoneBy(rs.getString("done_by"));
        cleaningArea.setCompletionDate(rs.getString("done_date"));
        cleaningArea.setApprovedStatus(rs.getBoolean("done_status"));

        return cleaningArea;
    }
}
