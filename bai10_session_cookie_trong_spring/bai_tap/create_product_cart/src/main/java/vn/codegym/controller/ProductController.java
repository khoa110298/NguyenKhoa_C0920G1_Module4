package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.service.ProductService;



@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping({"", "/list"})
    public String listProduct(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "/list";
    }

    @GetMapping("{id}/view")
    public String formView(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }



}
