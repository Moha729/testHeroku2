package com.example.testheroku2.Service;

import com.example.testheroku2.Model.Member;
import com.example.testheroku2.Model.Section;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionsService {

    public ArrayList<Section> allSections = new ArrayList<>();

    public void populateAllSectionsList (){
        if (allSections.size() == 0){
            allSections.add(new Section(1, "A", true));
            allSections.add(new Section(2, "B", true));
            allSections.add(new Section(3, "C", false));
        }
    }

/*    public List<Member> fetchAll () {
        return memberRepo.fetchAll();
    }*/

    public void addNew (Section s) {
        allSections.add(s);
    }

    public Section findById (int id){
        Section section = new Section(4, "3", false);
        for (int i = 0; i < allSections.size(); i++) {
            if (id==allSections.get(i).getSectionId()){
                section = allSections.get(i);
            }
        }
        return section;
    }

    public void updateById(int id, Section section){
        for (int i = 0; i < allSections.size(); i++) {
            if (section.getSectionId()==allSections.get(i).getSectionId()){
                allSections.get(i).setSectionName(section.getSectionName());
                allSections.get(i).setSectionActiveStatus(section.isSectionActiveStatus());
            }
        }
    }

}
