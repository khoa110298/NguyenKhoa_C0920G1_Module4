package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailController(){
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    @RequestMapping("/")
    String getIndex(){
        return "/index";
    }
    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    String validateEmail(@RequestParam("email") String email, Model model){
        boolean check = validate(email);
        if (!check){
            model.addAttribute("message", "Email is invalid");
            return "/index";
        }else {
            model.addAttribute("email", email);
            return "/success";
        }
    }
}
