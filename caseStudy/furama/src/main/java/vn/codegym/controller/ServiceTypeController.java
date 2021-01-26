package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.CustomerType;
import vn.codegym.entity.ServiceType;
import vn.codegym.service.ServiceTypeDAO;

@Controller
@RequestMapping("/serviceType")
public class ServiceTypeController {
    @Autowired
    ServiceTypeDAO customerTypeService;

    @GetMapping({"","/list"})
    public ModelAndView listCustomerType(){
        return new ModelAndView("/serviceType/list","customerTypeList",customerTypeService.findAll());
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customerType",new ServiceType());
        return "/serviceType/create";
    }
    @PostMapping("/save")
    public String createCustomerType(@ModelAttribute ServiceType customerType, RedirectAttributes redirectAttributes){
        customerTypeService.save(customerType);
        redirectAttributes.addFlashAttribute("message","create success!!!");
        return "redirect:/serviceType";
    }
    @GetMapping("/{id}/update")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        ServiceType customerType = customerTypeService.findById(id);
        model.addAttribute("customerType",customerType);
        return "/serviceType/edit";
    }
    @PostMapping("/update")
    public String editCustomerType(@ModelAttribute ServiceType customerType,RedirectAttributes redirectAttributes){
        customerTypeService.save(customerType);
        redirectAttributes.addFlashAttribute("message","update success!!!");
        return "redirect:/serviceType";
    }
    @GetMapping("/{id}/view")
    public String viewCustomerType(@PathVariable("id") Integer id,Model model){
        model.addAttribute("customerType",customerTypeService.findById(id));
        return "/serviceType/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomerType(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        customerTypeService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete success!!!!");
        return "redirect:/serviceType";
    }

}
