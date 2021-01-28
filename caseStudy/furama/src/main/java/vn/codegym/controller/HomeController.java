package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getLayout(){
        return "layout";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/403")
    public String error(){
        return "error";
    }
}
