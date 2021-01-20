package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.CustomerType;
import vn.codegym.service.CustomerTypeService;

@Controller
@RequestMapping("/customerType")
public class CustomerTypeController {
    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping({"","/list"})
    public ModelAndView listCustomerType(){
        return new ModelAndView("/customerType/list","customerTypeList",customerTypeService.findAll());
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customerType",new CustomerType());
        return "/customerType/create";
    }
    @PostMapping("/save")
    public String createCustomerType(@ModelAttribute CustomerType customerType, RedirectAttributes redirectAttributes){
        customerTypeService.save(customerType);
        redirectAttributes.addFlashAttribute("message","create success!!!");
        return "redirect:/customerType";
    }
    @GetMapping("/{id}/update")
    public String showEdit(@PathVariable("id") Integer id,Model model){
        CustomerType customerType = customerTypeService.findById(id);
        model.addAttribute("customerType",customerType);
        return "/customerType/edit";
    }
    @PostMapping("/update")
    public String editCustomerType(@ModelAttribute CustomerType customerType,RedirectAttributes redirectAttributes){
        customerTypeService.save(customerType);
        redirectAttributes.addFlashAttribute("message","update success!!!");
        return "redirect:/customerType";
    }
    @GetMapping("/{id}/view")
    public String viewCustomerType(@PathVariable("id") Integer id,Model model){
        model.addAttribute("customerType",customerTypeService.findById(id));
        return "/customerType/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomerType(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        customerTypeService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete success!!!!");
        return "redirect:/customerType";
    }

}
