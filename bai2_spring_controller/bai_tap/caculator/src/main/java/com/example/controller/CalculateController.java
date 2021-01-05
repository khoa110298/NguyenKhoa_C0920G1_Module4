package com.example.controller;

import com.example.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @GetMapping("/")
    public String getIndex(){
        return "/index";
    }
    @Autowired
    CalculateService calculateService;
    @PostMapping("/calculate")
    public String getCalculate(Model model, @RequestParam String number1,  @RequestParam String number2, @RequestParam String calculation){
        double firstNumber;
        double secondNumber;
        try {
            firstNumber = Double.parseDouble(number1);
            secondNumber = Double.parseDouble(number2);
        }catch (NumberFormatException e){
            model.addAttribute("message","number format exception");
            return "/index";
        }
        double result =calculateService.calculate(firstNumber,secondNumber,calculation);
        model.addAttribute("calculation", calculation);
        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("secondNumber", secondNumber);
        model.addAttribute("result", result);
        return "/index";
    }
}
