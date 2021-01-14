package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.codegym.model.MyCounter;

@Controller
@SessionAttributes("mycounter")
public class CounterController {
    @ModelAttribute("mycounter")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }
    @GetMapping("/count")
    public String get(@ModelAttribute("mycounter") MyCounter myCounter ) {
        myCounter.increment();
        return "/index";
    }
}
