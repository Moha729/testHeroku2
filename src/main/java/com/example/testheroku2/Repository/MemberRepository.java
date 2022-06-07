package com.example.testheroku2.Repository;

import com.example.testheroku2.Model.Member;
import com.example.testheroku2.Repository.Mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Member> fetchAll () {
        String sql = "SELECT id_id, name_name FROM test_two";
        RowMapper rowMapper = new MemberMapper();
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void addNew (Member m) {
        String sql = "INSERT INTO test_two VALUES (?);";
        jdbcTemplate.update(sql, m.getMemberName());
    }

    public Member findById (int id){
        return null;
    }

    public void updateById(int id, Member m){}

    public void archiveById(int id){}
}
