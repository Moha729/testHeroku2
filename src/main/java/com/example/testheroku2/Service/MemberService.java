package com.example.testheroku2.Service;

import com.example.testheroku2.Model.Member;
import com.example.testheroku2.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepo;

    public List<Member> fetchAll () {
        for (int i = 0; i < memberRepo.fetchAll().size(); i++) {
            System.out.println(memberRepo.fetchAll().get(i).getMemberName());

        }
        return memberRepo.fetchAll();
    }

    public void addNew (Member m) {
        memberRepo.addNew(m);
    }

    public Member findById (int id){
        return memberRepo.findById(id);
    }

    public void updateById(int id, Member m){
        memberRepo.updateById(id, m);
    }

    public void archiveById(int id){
        memberRepo.archiveById(id);
    }
}
