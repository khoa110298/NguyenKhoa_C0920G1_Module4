package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.entity.User;

@Controller
public class UserController {
    @GetMapping("/log-in")
    public String formLogIn(Model model){
        model.addAttribute("user",new User());
        return "/index";
    }
    @PostMapping("/validateUser")
    public String checkValidate(@Validated @ModelAttribute User user, BindingResult bindingResult, Model model){
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            return "/index";
        }else {
            model.addAttribute("abc",user);
            return "/result";
        }
    }
}
