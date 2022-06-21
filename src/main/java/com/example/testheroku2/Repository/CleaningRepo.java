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

    public ArrayList<CleaningArea> fetchAllSections(){
        String sql = "SELECT * FROM sections ORDER BY section_id";
        RowMapper<CleaningArea> rowMapper = new BeanPropertyRowMapper<>(CleaningArea.class);
        return (ArrayList<CleaningArea>) jdbcTemplate.query(sql, rowMapper);
    }

    public ArrayList<CleaningArea> fetchAll(int weekCount) {
        for (int i = 0; i < fetchAllSections().size(); i++) {
            System.out.println("LIST FROM SELECT SECTIONS "+fetchAllSections().get(i).getSectionName());
        }

        String sql = "SELECT section_id,  " +
                "assigned_to, done_by, done_date, done_status FROM cleaning_data "
                /*"JOIN sections ON cleaning_data.section_id = sections.section_id " +
                "WHERE week_count = ?"*/;
        RowMapper<CleaningArea> rowMapper = new CleaningAreaMapper();
        //System.out.println("HER GALT 1");
        ArrayList<CleaningArea> cleaningAreas = (ArrayList<CleaningArea>) jdbcTemplate.query(sql, rowMapper);
        //System.out.println("HER GALT 2");
        System.out.println("OUTOFBOUNCE SECTIONS.SIZE "+ fetchAllSections().size());
        System.out.println("OUTOFBOUNCE FROM CLEANING-DATA "+ cleaningAreas.size());
        for (int i = 0; i < cleaningAreas.size(); i++) {
            System.out.println("ZEUS_AS_ID "+ cleaningAreas.get(i).getSectionId());
            System.out.println("ZEUS_AS_NAME "+ cleaningAreas.get(i).getSectionName());
            if (fetchAllSections().get(i).getSectionId()==cleaningAreas.get(i).getSectionId()){
            cleaningAreas.get(i).setSectionName(fetchAllSections().get(i).getSectionName());
                System.out.println();
            }
        }
        return cleaningAreas;
    }

    public void addNew(CleaningArea cleaningArea){
        String sql = "INSERT INTO sections (section_id, section_name ) VALUES (?,?)";
        jdbcTemplate.update(sql, cleaningArea.getSectionId(), cleaningArea.getSectionName());
    }

    public CleaningArea findById(int id){
        String sql = "SELECT section_id, assigned_to, done_by, done_date, done_status " +
                "FROM cleaning_data WHERE section_id = ?";
        String sql2 = "SELECT * FROM cleaning_areas WHERE index_no = ?";
        RowMapper<CleaningArea> rowMapper = new CleaningAreaMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public void startCleaningData (int weekCount){
        for (int i = 0; i < fetchAllSections().size(); i++) {
            int sectionId = fetchAllSections().get(i).getSectionId();
            String sql = "INSERT INTO cleaning_data (week_count, section_id) VALUES  (?,?)";
            //String sql1 = "UPDATE cleaning_data SET week_count = ?, section_id = ?";
            jdbcTemplate.update(sql, weekCount, sectionId);
        }
    }

    public void setAssigendTo(int id, int noObjectProblemSetMemberIdToForeignKey, int weekCount){
        String sql = "UPDATE cleaning_data SET assigned_to = ? " +
                "WHERE section_id = ? AND week_count = ?";
        jdbcTemplate.update(sql, noObjectProblemSetMemberIdToForeignKey,
        id, weekCount);
    }


    public void setDoneBy(int id, CleaningArea section) {

//        Timestamp instant= Timestamp.from(Instant.now());
//
//        section.setCompletionDate(instant.toString());
//        System.out.println(section.getCompletionDate());

        //System.out.println(dateFormat.format(doneDateAndTime));

        String sql = "UPDATE cleaning_data SET done_by = ?, done_date=? " +
                "WHERE section_id =?";
        jdbcTemplate.update(sql, section.getDoneBy(), section.getCompletionDate(),
                id);

    }

    public void setApproved(int id, CleaningArea section) {
        String sql = "UPDATE cleaning_data SET done_status = ? WHERE section_id = ?";
        jdbcTemplate.update(sql, section.isApprovedStatus(),
                id);
    }
}
