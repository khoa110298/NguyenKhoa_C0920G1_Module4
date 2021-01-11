package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping({"","/list"})
    public String listCustomer(Model model){
        model.addAttribute("customerList",customerService.findAll());
        return "/list";
    }
    @GetMapping("/create")
    public String  showCreateForm(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }
}
