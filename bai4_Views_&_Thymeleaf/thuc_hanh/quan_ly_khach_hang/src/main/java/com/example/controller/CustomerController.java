package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/")
    public String index(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers",customerList);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customer.setId(customerService.findAll().get(customerService.findAll().size()-1).getId()+1);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","create success");
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/edit")
    public String showEdit(Model model, @PathVariable int id){
        model.addAttribute("customer",customerService.findById(id));
        return "/edit";
    }
    @PostMapping("/customer/update")
    public String editCustomer(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes){
        customerService.update(customer.getId(),customer);
        redirectAttributes.addFlashAttribute("message","update success!!");
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/delete")
    public String showDelete(Model model,@PathVariable int id){
        model.addAttribute("customer",customerService.findById(id));
        return "/delete";
    }
    @PostMapping("/customer/delete")
    public String deleteCustomer(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes){
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message","delete success!!!");
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}
