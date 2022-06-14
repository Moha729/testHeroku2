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
public class cleaningController {

    @Autowired
    CleaningService cleaningService;
    @Autowired
    MemberService memberService;




//    @GetMapping("/set-cleaning-on-section/{sectionID}")
//    public String setDesignated(@PathVariable("sectionID") int id, Model model){
//        model.addAttribute("oneArea", cleaningService.findById(id));
//        model.addAttribute("membersList", memberService.fetchAll());
//        return "cleaning/set-cleaning-on-section";
//    }
//
//    @PostMapping("/set-cleaning-on-section")
//    public String setDesignated (
//                                 @ModelAttribute CleaningArea cleaningArea){
//        System.out.println(cleaningArea.getAssignedTo()+" are we even here");
//        System.out.println(cleaningArea.getSectionName());
//        System.out.println(cleaningArea.getSectionId());
//        cleaningService.updateById(cleaningArea.getSectionId(), cleaningArea);
//        return "redirect:/";
//    }





}
