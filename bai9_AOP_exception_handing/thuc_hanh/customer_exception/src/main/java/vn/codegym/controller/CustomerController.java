package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.exception.DuplicateEmailException;
import vn.codegym.model.Customer;
import vn.codegym.service.CustomerService;
import vn.codegym.service.ProvinceService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;

    @GetMapping({"","/list"})
    public String listCustomers(Model model,@PageableDefault(value = 2) Pageable pageable){
        try {
            model.addAttribute("customerList",customerService.findAll(pageable));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("provinceList",provinceService.findAll());
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }
    @PostMapping("/save")
    public String createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) throws DuplicateEmailException {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","create success!!!");
        return "redirect:/customer/";
    }
    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("provinceList",provinceService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) throws DuplicateEmailException {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Update Success!!!");
        return "redirect:/customer/";
    }
    @GetMapping("/{id}/view")
    public String showCustomerByID(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message","Delete Success!!!");
        return "redirect:/customer/";
    }
    @PostMapping("/search")
    public ModelAndView searchByText(@RequestParam String inputSearch, @PageableDefault(value = 2)Pageable pageable){
        return new ModelAndView("customer/list", "customerList", customerService.findAllInputText(inputSearch, pageable));
    }

    @PostMapping
    public ModelAndView updateCustomer(Customer customer) {
        try {
            customerService.save(customer);
            return new ModelAndView("redirect:/customer/");
        } catch (DuplicateEmailException e) {
            return new ModelAndView("/customer/inputs-not-acceptable");
        }
    }
    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showErrorPage() {
        return new ModelAndView("/customer/inputs-not-acceptable");
    }
}
