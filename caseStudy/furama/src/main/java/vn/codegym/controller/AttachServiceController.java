package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.AttachService;
import vn.codegym.service.AttachServiceDAO;

import javax.validation.Valid;

@Controller
@RequestMapping("/attachService")
public class AttachServiceController {
    @Autowired
    AttachServiceDAO customerTypeService;

    @GetMapping({"","/list"})
    public ModelAndView listCustomerType(){
        return new ModelAndView("/attachService/list","customerTypeList",customerTypeService.findAll());
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("attachService",new AttachService());
        return "/attachService/create";
    }
    @PostMapping("/save")
    public String createCustomerType(@Valid @ModelAttribute AttachService customerType, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "/attachService/create";
        }else {
            customerTypeService.save(customerType);
            redirectAttributes.addFlashAttribute("message", "create success!!!");
            return "redirect:/attachService";
        }
    }
    @GetMapping("/{id}/update")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        AttachService customerType = customerTypeService.findById(id);
        model.addAttribute("customerType",customerType);
        return "/attachService/edit";
    }
    @PostMapping("/update")
    public String editCustomerType(@Valid @ModelAttribute AttachService customerType,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){
        if (bindingResult.hasErrors()){
            return "/attachService/edit";
        }else {
            customerTypeService.save(customerType);
            redirectAttributes.addFlashAttribute("message", "update success!!!");
            return "redirect:/attachService";
        }
    }
    @GetMapping("/{id}/view")
    public String viewCustomerType(@PathVariable("id") Integer id,Model model){
        model.addAttribute("customerType",customerTypeService.findById(id));
        return "/attachService/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomerType(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        customerTypeService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete success!!!!");
        return "redirect:/attachService";
    }
}
