package com.example.testheroku2.Controller;

import com.example.testheroku2.Model.Member;
import com.example.testheroku2.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewController {

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String getInd(Model model){
        model.addAttribute("MembersList", memberService.fetchAll());
        return "index";
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

    @GetMapping("/new")
    public String getInd2(){
        return "index2";
    }

}
