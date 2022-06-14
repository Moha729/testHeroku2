package com.example.testheroku2.Controller;

import com.example.testheroku2.Model.Member;
import com.example.testheroku2.Model.cleaning.CleaningArea;
import com.example.testheroku2.Model.weekNumberWrapper;
import com.example.testheroku2.Service.MemberService;
import com.example.testheroku2.Service.cleaning.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NewController {

    @Autowired
    MemberService memberService;
    @Autowired
    CleaningService cleaningService;

    @GetMapping("/")
    public String getInd(Model model, Model model2){

        List<CleaningArea> areas = cleaningService.fetchAll();


        model.addAttribute("MembersList", testMembers(areas));
        model2.addAttribute("sectionsList", areas);
        return "index4";
    }

    weekNumberWrapper weekNumb;


    @PostMapping("/")
    public String getWeekNumber(@ModelAttribute weekNumberWrapper weekNumb){
        System.out.println(weekNumb.getWeekNumb()+" weekNumb");
        return "redirect:/";
    }
    public ArrayList<Member> testMembers (/*int weekNumber*/List<CleaningArea> areas) {
        ArrayList<Member> members = new ArrayList<>();

        for (int i = 1; i <= 16; i++) {
            Member newMember = new Member();
            newMember.setMemberName("person" + i);
            members.add(newMember);
        }

        for (int i = areas.size(); i < members.size(); i++) {
            CleaningArea cleaningArea = new CleaningArea();
            cleaningArea.setSectionName("");
            areas.add(cleaningArea);
        }

        int k = 0;
        for (int j = 0; j < members.size(); j++) {
            System.out.println("Week " + (j + 1));

            if (j != 0) {
                k = members.size() - j;
            }
            for (int i = 0; i < members.size(); i++) {
                if (k >= members.size()) {
                    k = 0 ;
                }
                if (i >= areas.size()) {
                    System.out.println("O " + members.get( k).getMemberName());
                } else {
                    //System.out.println(areas.get(i) + " " + members.get(k));
                    areas.get(i).setAssignedTo(members.get(k).getMemberName());
                }
                k++;
            }
        }

        return members;
    }

    @GetMapping("/set-done-by/{sectionID}")
    public String setDoneBy(@PathVariable("sectionID") int id, Model model){
        List<CleaningArea> areas = cleaningService.fetchAll();
        System.out.println(id);
        model.addAttribute("oneArea", areas.get(id-1)/*cleaningService.findById(id)*/);
        model.addAttribute("membersList", testMembers(areas));
        return "cleaning/set-done-by";
    }

    @PostMapping("/set-done-by")
    public String setDoneBy(@ModelAttribute CleaningArea cleaningArea){
//        System.out.println(cleaningArea.getAssignedTo()+" are we even here");
//        System.out.println(cleaningArea.getSectionName());
//        System.out.println(cleaningArea.getSectionId());
        cleaningService.setDoneBy(cleaningArea.getSectionId(), cleaningArea);
        return "redirect:/";
    }

    @GetMapping("/new-member")
    public String newMember (){
        return "new-member";
    }

    @PostMapping("/new-member")
    public String newMember (@ModelAttribute Member member) {
        memberService.addNew(member);
        return "redirect:/";
    }

//    @GetMapping("/new")
//    public String getInd2(){
//        return "index2";
//    }

}
