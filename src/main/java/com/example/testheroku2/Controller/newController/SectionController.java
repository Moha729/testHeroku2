package com.example.testheroku2.Controller.newController;

import com.example.testheroku2.Model.Section;
import com.example.testheroku2.Service.SectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SectionController {

    @Autowired
    SectionsService sectionsService;

    //show sections
    @GetMapping("/show-sections")
    public String showSections(Model model){
        sectionsService.populateAllSectionsList();//FirstDayMethod
        model.addAttribute("allSections", sectionsService.allSections);
        return "/admin-templates/sections/show-sections";
    }

    //New member
    @GetMapping("/new-section")
    public String newSection() {
        return "/admin-templates/sections/new-section2";
    }
    @PostMapping("/new-section")
    public String newSection(@ModelAttribute Section section){
        sectionsService.addNew(section);
        return "redirect:/show-sections";
    }

//Update member
    @GetMapping("/update-section/{id}")
    public String updateSection(@PathVariable("id") int id, Model model){
        model.addAttribute("section", sectionsService.findById(id));
        return "/admin-templates/sections/update-section";
    }
    @PostMapping("/update-section")
    public String updateSection(@ModelAttribute Section section){
        sectionsService.updateById(section.getSectionId(), section);
        return "redirect:/show-sections";
    }

}
