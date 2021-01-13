package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.entity.User;

@Controller
public class UserController {
    @GetMapping("/login")
    public String showFormLogin(Model model){
        model.addAttribute("user",new User());
        return "/login";
    }
    @PostMapping("/validateUser")
    public String checkValidate(@Validated @ModelAttribute User user, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "/login";
        }else {
            model.addAttribute("abc",user);
            return "/result";
        }
    }
}
