package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.CustomerType;
import vn.codegym.entity.EducationDegree;
import vn.codegym.service.EducationDegreeService;

@Controller
@RequestMapping("/educationDegree")
public class EducationDegreeController {
    @Autowired
    EducationDegreeService customerTypeService;

    @GetMapping({"","/list"})
    public ModelAndView listCustomerType(){
        return new ModelAndView("/educationDegree/list","customerTypeList",customerTypeService.findAll());
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customerType",new EducationDegree());
        return "/educationDegree/create";
    }
    @PostMapping("/save")
    public String createCustomerType(@ModelAttribute EducationDegree customerType, RedirectAttributes redirectAttributes){
        customerTypeService.save(customerType);
        redirectAttributes.addFlashAttribute("message","create success!!!");
        return "redirect:/educationDegree";
    }
    @GetMapping("/{id}/update")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        EducationDegree customerType = customerTypeService.findById(id);
        model.addAttribute("customerType",customerType);
        return "/educationDegree/edit";
    }
    @PostMapping("/update")
    public String editCustomerType(@ModelAttribute EducationDegree customerType,RedirectAttributes redirectAttributes){
        customerTypeService.save(customerType);
        redirectAttributes.addFlashAttribute("message","update success!!!");
        return "redirect:/educationDegree";
    }
    @GetMapping("/{id}/view")
    public String viewCustomerType(@PathVariable("id") Integer id,Model model){
        model.addAttribute("customerType",customerTypeService.findById(id));
        return "/educationDegree/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomerType(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        customerTypeService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete success!!!!");
        return "redirect:/educationDegree";
    }

}
