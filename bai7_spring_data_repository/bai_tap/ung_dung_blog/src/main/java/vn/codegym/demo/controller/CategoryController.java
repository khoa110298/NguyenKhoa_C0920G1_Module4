package vn.codegym.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.demo.model.Category;
import vn.codegym.demo.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService customerService;

    @GetMapping({"","/list"})
    public String listCategory(Model model){
        model.addAttribute("customerList",customerService.findAll());
        return "/category/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customer",new Category());
        return "category/create";
    }
    @PostMapping("/save")
    public String createCategory(@ModelAttribute Category customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","create success!!!");
        return "redirect:/category";
    }
    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "category/edit";
    }

    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Update Success!!!");
        return "redirect:/category";
    }
    @GetMapping("/{id}/view")
    public String showCategoryByID(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/category/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable int id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message","Delete Success!!!");
        return "redirect:/category";
    }
}
