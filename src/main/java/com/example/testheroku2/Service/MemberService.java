package com.example.testheroku2.Service;

import com.example.testheroku2.Model.Member;
import com.example.testheroku2.Repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepo memberRepo;

    public ArrayList<Member> allMembers = new ArrayList<>();

    public void populateAllMembersList (){
        if (allMembers.size() == 0){
            allMembers.add(new Member("test1", 1, true));
            allMembers.add(new Member("test2", 2, true));
            allMembers.add(new Member("test3", 3, false));
        }
    }

    public List<Member> fetchAll () {
        return memberRepo.fetchAll();
    }

    public void addNew (Member m) {
        allMembers.add(m);
    }

    public Member findById (int id){
        Member member = new Member("testX", 3, false);
        for (int i = 0; i < allMembers.size(); i++) {
            if (id==allMembers.get(i).getMemberId()){
                member = allMembers.get(i);
            }
        }
        return member;
    }

    public void updateById(int id, Member member){
        for (int i = 0; i < allMembers.size(); i++) {
            if (member.getMemberId()==allMembers.get(i).getMemberId()){
                allMembers.get(i).setMemberName(member.getMemberName());
                allMembers.get(i).setMemberActiveStatus(member.isMemberActiveStatus());
            }
        }
    }

}
