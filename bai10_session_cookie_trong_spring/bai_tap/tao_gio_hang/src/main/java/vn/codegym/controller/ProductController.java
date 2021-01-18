package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.codegym.entity.Cart;
import vn.codegym.entity.Product;
import vn.codegym.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
//@SessionAttributes("cartList")
public class ProductController {
    @Autowired
    ProductService productService;
    @ModelAttribute("cartList")
    public List<Cart> setCartList(){
        return new ArrayList<>();
    }
    @GetMapping({"","/list"})
    public String listProduct(Model model){
        model.addAttribute("productList",productService.findAll());
        return "/list";
    }


}
