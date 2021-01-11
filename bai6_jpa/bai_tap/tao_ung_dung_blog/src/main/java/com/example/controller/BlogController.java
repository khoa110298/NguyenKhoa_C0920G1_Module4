package com.example.controller;

import com.example.model.Blog;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService customerService;

    @GetMapping({"","/list"})
    public String listCustomers(Model model){
        model.addAttribute("customerList",customerService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customer",new Blog());
        return "/create";
    }
    @PostMapping("/save")
    public String createCustomer(@ModelAttribute Blog customer, RedirectAttributes redirectAttributes){
        customerService.insertProduct(customer);
        redirectAttributes.addFlashAttribute("message","create success!!!");
        return "redirect:/blog/list";
    }
    @GetMapping("/{id}/update")
    public String goUpdate(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Blog customer, RedirectAttributes redirectAttributes) {
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("message","Update Success!!!");
        return "redirect:/blog/list";
    }
    @GetMapping("/{id}/view")
    public String showProductByID(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable int id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message","Delete Success!!!");
        return "redirect:/blog/list";
    }
}
