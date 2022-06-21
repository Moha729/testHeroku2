package com.example.testheroku2.Service;

import com.example.testheroku2.Model.Cleaning;
import com.example.testheroku2.Model.Member;
import com.example.testheroku2.Model.Section;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class CleaningService2 {

    public ArrayList<Cleaning> allCleanings = new ArrayList<>();

    public void populateAllCleaningsList (int weekNumb, ArrayList<Section> section, ArrayList<Member> assignedTo){
        if (allCleanings.size() == 0){
            allCleanings.add(new Cleaning());
            allCleanings.add(new Cleaning());
            allCleanings.add(new Cleaning());
            for (int i = 0; i < allCleanings.size(); i++) {
                allCleanings.get(i).setCleaningId(i+1);
                allCleanings.get(i).setWeekNumb(weekNumb);
                allCleanings.get(i).setCleaningSection(section.get(i));
                allCleanings.get(i).setAssignedTo(assignedTo.get(i));
                if(allCleanings.get(i).getDoneBy()==null){
                    allCleanings.get(i).setDoneBy(new Member(" ", 0, false));
                }
            }
        }
    }


    public void newCleaning (Cleaning cleaning, ArrayList<Section> sections,
                             ArrayList<Member> members){
        for (int i = 0; i < sections.size(); i++) {
            if (cleaning.getCleaningSection().getSectionName().equalsIgnoreCase(sections.get(i).getSectionName())){
                cleaning.setCleaningSection(sections.get(i));
            }
        }
        for (int i = 0; i < members.size(); i++) {
            if (cleaning.getAssignedTo().getMemberName().equalsIgnoreCase(members.get(i).getMemberName())){
                cleaning.setAssignedTo(members.get(i));
            }
        }
        cleaning.setDoneBy(new Member(" ", 0, false));
        allCleanings.add(cleaning);
    }

    public Cleaning findById (int id){
        Cleaning cleaning = new Cleaning();
        for (int i = 0; i < allCleanings.size(); i++) {
            if (id==allCleanings.get(i).getCleaningId()){
                cleaning = allCleanings.get(i);
            }
        }
        return cleaning;
    }

    public void updateById(int id, Cleaning cleaning, ArrayList<Section> sections,
                           ArrayList<Member> members, String toConvert){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = null;
        try {
            myDate = formatter.parse(toConvert);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat myDateFormatted = new SimpleDateFormat("yyyy-MM-dd");
        //String formatedDAte = myDateFormatted.format(myDate);
        cleaning.setCompletionDate(myDate);

        for (int i = 0; i < sections.size(); i++) {
            if (cleaning.getCleaningSection().getSectionName().equalsIgnoreCase(sections.get(i).getSectionName())){
                cleaning.setCleaningSection(sections.get(i));
            }
        }
        for (int i = 0; i < members.size(); i++) {
            if (cleaning.getAssignedTo().getMemberName().equalsIgnoreCase(members.get(i).getMemberName())){
                cleaning.setAssignedTo(members.get(i));
            }
        }
        for (int i = 0; i < members.size(); i++) {
            if (cleaning.getDoneBy().getMemberName().equalsIgnoreCase(members.get(i).getMemberName())){
                cleaning.setDoneBy(members.get(i));
            }
        }
//        System.out.println(cleaning.getCompletionDate());
       for (int i = 0; i < allCleanings.size(); i++) {
            if (cleaning.getCleaningId()==allCleanings.get(i).getCleaningId()){
                allCleanings.get(i).setWeekNumb(cleaning.getWeekNumb());
                allCleanings.get(i).setCleaningSection(cleaning.getCleaningSection());
              //  System.out.println("G"+cleaning.getAssignedTo().getMemberName());
                allCleanings.get(i).setAssignedTo(cleaning.getAssignedTo());
                allCleanings.get(i).setDoneBy(cleaning.getDoneBy());
                allCleanings.get(i).setCompletionDate(cleaning.getCompletionDate());
         //       System.out.println(allCleanings.get(i).getCompletionDate());
                allCleanings.get(i).setApprovedStatus(cleaning.isApprovedStatus());
//                System.out.println(allCleanings.get(i).getAssignedTo().getMemberId());

            }
        }
/*         System.out.println(cleaning.getAssignedTo().getMemberId()+"E");
        System.out.println(cleaning.getDoneBy().getMemberId()+"F");
        System.out.println("weekNumb="+cleaning.getWeekNumb());*/

    }

}
