package com.SSF_day13lecture.SSF_day13lecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/session")
public class SessionController {
    

    @GetMapping("/firstpage")
    public String firstPage() {
        return "pageA";
    }

    @PostMapping("/firstpage")
    public String postFromFirstpage(@RequestBody MultiValueMap<String, String> entity, HttpSession session, Model model) {
        String fName = entity.getFirst("fullname");
        session.setAttribute("myname", fName);

        model.addAttribute("myFullName", fName);
        return "pageB";
    }

    @GetMapping("/thirdpage")
    public String thirdPage(HttpSession session, Model model) {
        if (session.getAttribute("myname") == null)
            return "redirect:/session/firstpage";

        model.addAttribute("myFullName", session.getAttribute("myname"));
        return "pageC";
    }
    
    @GetMapping("/reset")
    public String reset(HttpSession session, Model model) {

        session.invalidate();

        return "redirect:/session/firstpage";
    }
    
    
}
