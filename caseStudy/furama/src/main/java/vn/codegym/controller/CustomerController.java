package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.Customer;
import vn.codegym.entity.CustomerType;
import vn.codegym.service.CustomerService;
import vn.codegym.service.CustomerTypeService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerTypeService customerTypeService;
    @Autowired
    CustomerService customerService;
    @GetMapping({"","/list"})
    public String listCustomer(Model model, @PageableDefault(value = 5)Pageable pageable){
        model.addAttribute("customerList",customerService.findAll(pageable));
        return "/customer/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }
    @PostMapping("/save")
    public String createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){

        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","create success!!!");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/view")
    public String customerDetail(@PathVariable("id") String id,Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "/customer/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable("id") String id,RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete success!!!");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/update")
    public String showUpdateCustomer(@PathVariable("id") String id,Model model){
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("customer",customerService.findById(id));
        return "/customer/edit";
    }
    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes,Model model){
        String idCus = customer.getId();
        boolean check = false;
        for (Customer cus:customerService.findAll()) {
            if (idCus.equals(cus.getId())) {
                check = true;
                break;
            }
        }
        if (check) {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "update success!!!");
            return "redirect:/customer";
        }else {
                model.addAttribute("customerTypeList",customerTypeService.findAll());
                model.addAttribute("message","id không tồn tại !!!");
                return "/customer/edit";
        }
    }
    @PostMapping("/search")
    public String findByNameCustomer(@RequestParam String keyword, @PageableDefault(value = 5)Pageable pageable,Model model){
        model.addAttribute("customerList",customerService.findAllInputText(keyword,pageable));
        return "/customer/list";
    }
}
