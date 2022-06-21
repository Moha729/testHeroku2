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

    public void startCleaningData (int weekCount){
        cleaningRepo.startCleaningData(weekCount);
    }


        public ArrayList<CleaningArea> fetchAllSections () {
        for (int i = 0; i < cleaningRepo.fetchAllSections().size(); i++) {
            System.out.println("Areas raw: "+cleaningRepo.fetchAllSections().get(i).getSectionName());
        }
        return cleaningRepo.fetchAllSections();
    }

    public ArrayList<CleaningArea> fetchAll(int weekCount){
        for (int i = 0; i < cleaningRepo.fetchAll(weekCount).size(); i++) {
            System.out.println("from service "+cleaningRepo.fetchAll(weekCount).get(i).getSectionName());
        }
        return cleaningRepo.fetchAll(weekCount);
    }

    public void addNew(CleaningArea cleaningArea) {
        cleaningRepo.addNew(cleaningArea);
    }

    public CleaningArea findById(int id){
        return cleaningRepo.findById(id);
    }

    public void setAssignedTo(int id, int noObjectProblemSetMemberIdToForeignKey, int weekCOunt){
        cleaningRepo.setAssigendTo(id, noObjectProblemSetMemberIdToForeignKey, weekCOunt);
    }

    public void setAssigenTo(ArrayList<Member> members, ArrayList<CleaningArea> areas, int currentWeek){
        int weeksCount = areas.size();
        System.out.println("Weeks count: "+ weeksCount);
        int membersCount = members.size();

        for (int i = 0; i < currentWeek; i++) {
            for (int j = 0; j < weeksCount; j++) {
                for (int k = 0; k < membersCount; k++) {
                    areas.get(j).setAssignedTo(members.get(k).getMemberName());
                    //cleaningRepo.setAssigendTo(j, areas.get(j), 1);

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
