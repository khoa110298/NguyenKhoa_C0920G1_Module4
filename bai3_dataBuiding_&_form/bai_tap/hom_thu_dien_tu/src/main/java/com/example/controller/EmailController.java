package com.example.controller;

import com.example.model.Email;
import com.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;
    @GetMapping("/edit")
    public String showEmail(Model model){
        model.addAttribute("language",emailService.languageEmail());
        model.addAttribute("page",emailService.pageEmail());
        model.addAttribute("email",new Email());
        return "/show";
    }
    @PostMapping("/email")
    public String updateEmail(Model model, @ModelAttribute Email email){
        model.addAttribute("email",email);
        return "/edit";
    }
}
