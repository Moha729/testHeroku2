package com.example.testheroku2.Service.cleaning;

import com.example.testheroku2.Model.Member;
import com.example.testheroku2.Model.cleaning.CleaningArea;
import com.example.testheroku2.Repository.CleaningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CleaningService {

    @Autowired
    CleaningRepo cleaningRepo;

    public ArrayList<CleaningArea> fetchAll(){
        for (int i = 0; i < cleaningRepo.fetchAll().size(); i++) {
            System.out.println(cleaningRepo.fetchAll().get(i).getSectionName());
        }
        return cleaningRepo.fetchAll();
    }

    public void addNew(CleaningArea cleaningArea) {
        cleaningRepo.addNew(cleaningArea);
    }

    public CleaningArea findById(int id){
        return cleaningRepo.findById(id);
    }

    public void updateById(int id, CleaningArea section){
        cleaningRepo.setAssigendTo(id, section);
    }

    public void setAssigenTo(ArrayList<Member> members, ArrayList<CleaningArea> areas, int currentWeek){
        int weeksCount = areas.size();
        System.out.println("Weeks count: "+ weeksCount);
        int membersCount = members.size();

        for (int i = 0; i < currentWeek; i++) {
            for (int j = 0; j < weeksCount; j++) {
                for (int k = 0; k < membersCount; k++) {
                    areas.get(j).setAssignedTo(members.get(k).getMemberName());
                    cleaningRepo.setAssigendTo(j, areas.get(j));

                }
            }
        }
    }


    public void setDoneBy(int sectionId, CleaningArea cleaningArea) {
        cleaningRepo.setDoneBy(cleaningArea.getSectionId(), cleaningArea);
    }

    public void setApproved(int sectionId, CleaningArea cleaningArea) {
        cleaningRepo.setApproved(cleaningArea.getSectionId(), cleaningArea);

    }
}
