package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.PhoneNumber;

import javax.validation.Valid;
@Controller
public class PhoneNumberController {
    @GetMapping("/number")
    public String numberValidate(Model model){
        model.addAttribute("phoneNumber",new PhoneNumber());
        return "/index";
    }
    @PostMapping("/numValidate")
    public String checkValidate(@Valid @ModelAttribute PhoneNumber phoneNumber, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "/index";
        }else {
            model.addAttribute("abc",phoneNumber);
            return "/result";
        }
    }
}
