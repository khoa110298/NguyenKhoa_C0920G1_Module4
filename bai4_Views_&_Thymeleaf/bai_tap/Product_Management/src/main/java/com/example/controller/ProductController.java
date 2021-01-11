package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping({"","/list"})
    public String listProduct(Model model) {
        model.addAttribute("productList", productService.selectAllProduct());
        return "/list";
    }
    @GetMapping("/create")
    public String goInsert(Model model) {
        model.addAttribute("product", new Product());
        return "/insert";
    }
    @PostMapping("/create")
    public String insertProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        product.setId(productService.selectAllProduct().get(productService.selectAllProduct().size()-1).getId()+1);
        productService.insertProduct(product);
        redirectAttributes.addFlashAttribute("message", "Create Success!!!");
        return "redirect:/product/list";
    }

    @GetMapping("/{id}/update")
    public String goUpdate(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.selectProductById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.updateProduct(product);
        redirectAttributes.addFlashAttribute("message","Update Success!!!");
        return "redirect:/product/list";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message","Delete Success!!!");
        return "redirect:/product/list";
    }

    @GetMapping("/{id}/view")
    public String showProductByID(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.selectProductById(id));
        return "/view";
    }

}
