package com.example.testheroku2.Controller.cleaning;

import com.example.testheroku2.Model.WeekNumberWrapper;
import com.example.testheroku2.Model.cleaning.CleaningArea;
import com.example.testheroku2.Service.MemberService;
import com.example.testheroku2.Service.cleaning.CleaningService;
import com.example.testheroku2.Service.WeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CleaningAdminController {

    @Autowired
    CleaningService cleaningService;
    @Autowired
    MemberService memberService;
    @Autowired
    WeekService weekService;

    WeekNumberWrapper weekNumb = new WeekNumberWrapper();

/*
    @GetMapping("/manage-cleaning")
    public String getManageCleaning (Model model, Model model2){
        if (weekNumb.getWeekNumb() == 0){
            System.out.println("Week numb is "+weekNumb.getWeekNumb());
            weekNumb.setWeekNumb(weekService.getBeforeWeek());
            System.out.println("Week numb is set to: "+weekNumb.getWeekNumb());
        }
        //model.addAttribute("MembersList", memberService.fetchAll());
        model2.addAttribute("sectionsList", cleaningService.fetchAllSections());
        return "/cleaning/manage-cleaning";
    }

    @GetMapping("/add-new-section")
    public String addNewSection(){
        return "cleaning/add-new-section";
    }

    @PostMapping("/add-new-section")
    public String addNewSection(@ModelAttribute CleaningArea cleaningArea){
        cleaningService.addNew(cleaningArea);
        return "redirect:/manage-cleaning";
    }

    //set-approved
    @GetMapping("/set-approved/{sectionID}")
    public String setApproved(@PathVariable("sectionID") int id, Model model){
        model.addAttribute("oneArea", cleaningService.findById(id));
        model.addAttribute("membersList", memberService.fetchAll());
        return "cleaning/set-approved";
    }

    @PostMapping("/set-approved")
    public String setApproved(@ModelAttribute CleaningArea cleaningArea){
        System.out.println(cleaningArea.getAssignedTo()+" are we even here");
        System.out.println(cleaningArea.getSectionName());
        System.out.println(cleaningArea.getSectionId());
        cleaningService.setApproved(cleaningArea.getSectionId(), cleaningArea);
        return "redirect:/manage-cleaning";
    }

    @PostMapping("/start-new-week")
    public String startCleaningData (@ModelAttribute WeekNumberWrapper weekNumb){
        weekService.updateWeek(weekNumb.getWeekNumb());//UPDATE OR GET WTF??
        cleaningService.startCleaningData(weekNumb.getWeekNumb());
        return "redirect:/";
    }
*/

}
