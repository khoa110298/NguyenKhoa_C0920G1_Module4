package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.CustomerType;
import vn.codegym.entity.Position;
import vn.codegym.service.PositionService;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    PositionService customerTypeService;

    @GetMapping({"","/list"})
    public ModelAndView listCustomerType(){
        return new ModelAndView("/position/list","customerTypeList",customerTypeService.findAll());
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customerType",new Position());
        return "/position/create";
    }
    @PostMapping("/save")
    public String createCustomerType(@ModelAttribute Position customerType, RedirectAttributes redirectAttributes){
        customerTypeService.save(customerType);
        redirectAttributes.addFlashAttribute("message","create success!!!");
        return "redirect:/position";
    }
    @GetMapping("/{id}/update")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        Position customerType = customerTypeService.findById(id);
        model.addAttribute("customerType",customerType);
        return "/position/edit";
    }
    @PostMapping("/update")
    public String editCustomerType(@ModelAttribute Position customerType,RedirectAttributes redirectAttributes){
        customerTypeService.save(customerType);
        redirectAttributes.addFlashAttribute("message","update success!!!");
        return "redirect:/position";
    }
    @GetMapping("/{id}/view")
    public String viewCustomerType(@PathVariable("id") Integer id,Model model){
        model.addAttribute("customerType",customerTypeService.findById(id));
        return "/position/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomerType(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        customerTypeService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete success!!!!");
        return "redirect:/position";
    }

}
