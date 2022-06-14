package com.example.testheroku2.Controller.cleaning;

import com.example.testheroku2.Model.cleaning.CleaningArea;
import com.example.testheroku2.Service.MemberService;
import com.example.testheroku2.Service.cleaning.CleaningService;
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

    @GetMapping("/manage-cleaning")
    public String getManageCleaning (Model model, Model model2){
        model.addAttribute("MembersList", memberService.fetchAll());
        model2.addAttribute("sectionsList", cleaningService.fetchAll());
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

}
