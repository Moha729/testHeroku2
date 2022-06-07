package com.example.testheroku2.Repository.Mapper;

import com.example.testheroku2.Model.Member;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Member member = new Member();

        member.setMemberId(rs.getInt("id_id"));
        member.setMemberName(rs.getString("name_name"));
        return member;
    }
}
