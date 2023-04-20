package com.hivetech.controller;

import com.hivetech.services.MemberServices;
import com.hivetech.entities.Member;
import jakarta.servlet.http.HttpServletRequest;
//import org.hibernate.annotations.AttributeAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class MemberController {
    @Autowired
    private MemberServices memberServices;

    @GetMapping("/register")
    public String showRegistrationFor(Model model) {
        model.addAttribute("memberRegister", new Member());
        return "Register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("memberRegister") Member member, Model model) {

        Member memberCheck = memberServices.getMembersByName(member.getUsername());
        if (memberCheck != null) {
            return "/register";
        } else {
            Date date = Date.valueOf(LocalDate.now());
            member.setCreatedDate(date);
            memberServices.createMember(member);
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("memberLogin", new Member());
        return "Login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("memberLogin") Member member, BindingResult result, Model model) {
        Member memberLogin = memberServices.getMembersByName(member.getUsername());
        if (memberLogin == null) {
            result.rejectValue("username", null, "Username is not available");
        }
        else if (memberServices.validate(member.getUsername(), member.getPassword())) {
            model.addAttribute("member", memberLogin);
            return "EditProfile";
        }
        return "/login";

    }

//    @GetMapping("/edit-profile")
//    public String showProfileForm(Model model) {
////        model.addAttribute("member", new Member());
//        return "EditProfile";
//    }

    @PostMapping("/edit-profile")
    public String updateProfile(@ModelAttribute("member") Member member, Model model, RedirectAttributes redirectAttributes) {
        memberServices.updateMember(member);
        Member memberUpdate = memberServices.getMembersByName(member.getUsername());
//        model.addAttribute("member", memberUpdate);
        redirectAttributes.addFlashAttribute("member", memberUpdate);
        return "redirect:/add";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
