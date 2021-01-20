package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.CustomerType;
import vn.codegym.entity.Division;
import vn.codegym.service.DivisionService;

@Controller
@RequestMapping("/division")
public class DivisionController {
    @Autowired
    DivisionService customerTypeService;
    @GetMapping({"","/list"})
    public ModelAndView listCustomerType(){
        return new ModelAndView("/division/list","customerTypeList",customerTypeService.findAll());
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customerType",new Division());
        return "/division/create";
    }
    @PostMapping("/save")
    public String createCustomerType(@ModelAttribute Division customerType, RedirectAttributes redirectAttributes){
        customerTypeService.save(customerType);
        redirectAttributes.addFlashAttribute("message","create success!!!");
        return "redirect:/division";
    }
    @GetMapping("/{id}/update")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        Division customerType = customerTypeService.findById(id);
        model.addAttribute("customerType",customerType);
        return "/division/edit";
    }
    @PostMapping("/update")
    public String editCustomerType(@ModelAttribute Division customerType,RedirectAttributes redirectAttributes){
        customerTypeService.save(customerType);
        redirectAttributes.addFlashAttribute("message","update success!!!");
        return "redirect:/division";
    }
    @GetMapping("/{id}/view")
    public String viewCustomerType(@PathVariable("id") Integer id,Model model){
        model.addAttribute("customerType",customerTypeService.findById(id));
        return "/division/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomerType(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        customerTypeService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete success!!!!");
        return "redirect:/division";
    }
}
