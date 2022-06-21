package com.example.testheroku2.Controller.newController;

import com.example.testheroku2.Model.Cleaning;
import com.example.testheroku2.Model.DateConverter;
import com.example.testheroku2.Model.Member;
import com.example.testheroku2.Model.Section;
import com.example.testheroku2.Service.CleaningService2;
import com.example.testheroku2.Service.MemberService;
import com.example.testheroku2.Service.SectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

@Controller
public class CleaningController {

    @Autowired
    CleaningService2 cleaningService;
    @Autowired
    MemberService memberService;
    @Autowired
    SectionsService sectionsService;




    @GetMapping("/show-cleanings")
    public String showCleanings (Model model){

        cleaningService.populateAllCleaningsList(1, sectionsService.allSections,
                memberService.allMembers);
        model.addAttribute("allSections", sectionsService.allSections);
        model.addAttribute("allMembers", memberService.allMembers);
        model.addAttribute("allCleanings", cleaningService.allCleanings);

        return "/admin-templates/cleanings/show-cleanings";
    }

    @GetMapping("/new-cleaning")
    public String newCleaning (Model model, Model sectionsModel, Model assignedToModel){
        model.addAttribute("allSections", sectionsService.allSections);
        model.addAttribute("allMembers", memberService.allMembers);
        return "/admin-templates/cleanings/new-cleaning";
    }

    @PostMapping("/new-cleaning")
    public String newCleaning(@ModelAttribute Cleaning cleaning){
        cleaningService.newCleaning(cleaning, sectionsService.allSections,
                memberService.allMembers);
        return "redirect:/show-cleanings";
    }

    @GetMapping("/update-cleaning/{id}")
    public String updateCleaning (@PathVariable ("id") int id, Model model) {
        model.addAttribute("cleaning", cleaningService.findById(id));
        model.addAttribute("allSections", sectionsService.allSections);
        model.addAttribute("allMembers", memberService.allMembers);
        return "/admin-templates/cleanings/update-cleaning";
    }
    @PostMapping("/update-cleaning")
    public String updateCleaning (@ModelAttribute Cleaning cleaning, @ModelAttribute DateConverter dateConverter){
        cleaningService.updateById(cleaning.getCleaningId(), cleaning,
                sectionsService.allSections, memberService.allMembers, dateConverter.getTheDate());
        return "redirect:/show-cleanings";
    }

}
