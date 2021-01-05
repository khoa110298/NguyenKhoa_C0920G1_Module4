package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String getIndex(){
        return "/index";
    }
    @GetMapping("/save")
    public String getOrderSandwich(Model model, @RequestParam String[] condiment){
        model.addAttribute("condiments",condiment);
        return "/show";
    }
}
