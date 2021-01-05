package com.example.controller;

import com.example.model.Login;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/home")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("/home","login",new Login());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView show(@ModelAttribute("login") Login login){
        User user = UserService.checkLogin(login);
        if (user == null){
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/index","user",user);
            return modelAndView;
        }
    }
}
