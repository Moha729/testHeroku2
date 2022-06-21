package com.example.testheroku2.Controller.newController;

import com.example.testheroku2.Model.Member;
import com.example.testheroku2.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

//show members
    @GetMapping("/show-members")
    public String showMembers(Model model){
        memberService.populateAllMembersList();
        model.addAttribute("allMembers", memberService.allMembers);
        return "/admin-templates/members/show-members";
    }

//New member
    @GetMapping("/new-member")
    public String newMember() {
        return "/admin-templates/members/new-member2";
    }
    @PostMapping("/new-member")
    public String newMember(@ModelAttribute Member member){
        memberService.addNew(member);
        return "redirect:/show-members";
    }

//Update member

    @GetMapping("/update-member/{id}")
    public String updateMember(@PathVariable ("id") int id, Model model){
        model.addAttribute("member", memberService.findById(id));
        return "/admin-templates/members/update-member";
    }
    @PostMapping("/update-member")
    public String updateMember(@ModelAttribute Member member){
        memberService.updateById(member.getMemberId(), member);
        return "redirect:/show-members";
    }

}

