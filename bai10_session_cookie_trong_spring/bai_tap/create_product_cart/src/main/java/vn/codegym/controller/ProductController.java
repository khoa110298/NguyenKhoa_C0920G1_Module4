package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.Cart;
import vn.codegym.entity.Product;
import vn.codegym.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
@SessionAttributes("cartList")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cartList")
    public List<Cart> setCartList() {
        return new ArrayList<>();
    }

    @GetMapping({"", "/list"})
    public String listProduct(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "/list";
    }

    @GetMapping("/view/{id}")
    public String formView(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @GetMapping("/addToCart/{id}")
    public ModelAndView addToCart(@ModelAttribute("cartList") Cart cart, @PathVariable Integer id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("product", product);
        if (product == null) {
            modelAndView.addObject("message", "Error");
        } else {
            cart.addToCart(product);
            modelAndView.addObject("message","Add  to cart successfully Amount: ");
        }
        return modelAndView;
    }
    @GetMapping("/cart")
    public String goToCart(@ModelAttribute("cart") Cart cart,Model model){
       model.addAttribute("list",cart.getCart());
        return "/cart";
    }
    @GetMapping("/cart/{id}")
    public ModelAndView removeProduct(@ModelAttribute("cart") Cart cart,@PathVariable("id") Integer id){
        cart.removeProduct(productService.findById(id));
        return new ModelAndView("redirect:/cart");
    }

}
