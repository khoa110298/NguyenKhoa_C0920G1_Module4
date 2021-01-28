package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.RentType;
import vn.codegym.entity.ServiceType;
import vn.codegym.service.RentTypeService;

import javax.validation.Valid;

@Controller
@RequestMapping("/rentType")
public class RentTypeController {
    @Autowired
    RentTypeService customerTypeService;

    @GetMapping({"", "/list"})
    public ModelAndView listCustomerType() {
        return new ModelAndView("/rentType/list", "customerTypeList", customerTypeService.findAll());
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("rentType", new RentType());
        return "/rentType/create";
    }

    @PostMapping("/save")
    public String createCustomerType(@Valid @ModelAttribute RentType RentType, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            return "/rentType/create";
        } else {
            customerTypeService.save(RentType);
            redirectAttributes.addFlashAttribute("message", "create success!!!");
            return "redirect:/rentType";
        }
    }

    @GetMapping("/{id}/update")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        RentType customerType = customerTypeService.findById(id);
        model.addAttribute("customerType", customerType);
        return "/rentType/edit";
    }

    @PostMapping("/update")
    public String editCustomerType(@Valid @ModelAttribute RentType customerType, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            return "/rentType/edit";
        } else {
            customerTypeService.save(customerType);
            redirectAttributes.addFlashAttribute("message", "update success!!!");
            return "redirect:/rentType";
        }
    }

    @GetMapping("/{id}/view")
    public String viewCustomerType(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("customerType", customerTypeService.findById(id));
        return "/rentType/view";
    }

    @GetMapping("/{id}/delete")
    public String deleteCustomerType(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        customerTypeService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete success!!!!");
        return "redirect:/rentType";
    }
}
