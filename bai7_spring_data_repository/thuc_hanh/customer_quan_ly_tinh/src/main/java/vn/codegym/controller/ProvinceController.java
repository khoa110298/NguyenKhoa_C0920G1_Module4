package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Customer;
import vn.codegym.model.Province;
import vn.codegym.service.CustomerService;
import vn.codegym.service.ProvinceService;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private ProvinceService customerService;

    @GetMapping({"","/list"})
    public String listCustomers(Model model){
        model.addAttribute("customerList",customerService.findAll());
        return "/province/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customer",new Province());
        return "province/create";
    }
    @PostMapping("/save")
    public String createCustomer(@ModelAttribute Province customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","create success!!!");
        return "redirect:/province/list";
    }
    @GetMapping("/{id}/update")
    public String goUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "province/edit";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Province customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Update Success!!!");
        return "redirect:/province/";
    }
    @GetMapping("/{id}/view")
    public String showProductByID(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/province/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message","Delete Success!!!");
        return "redirect:/province/";
    }
}
