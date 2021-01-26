package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.ContractDetail;
import vn.codegym.entity.CustomerType;
import vn.codegym.service.AttachServiceDAO;
import vn.codegym.service.ContractDetailService;
import vn.codegym.service.ContractService;

import javax.validation.Valid;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    ContractDetailService contractDetailService;
    @Autowired
    ContractService contractService;
    @Autowired
    AttachServiceDAO attachServiceDAO;

    @GetMapping({"", "/list"})
    public ModelAndView listCustomerType() {
        return new ModelAndView("/contractDetail/list", "customerTypeList", contractDetailService.findAll());
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("contractList", contractService.findAll());
        model.addAttribute("attachServiceList", attachServiceDAO.findAll());
        model.addAttribute("customerType", new ContractDetail());
        return "/contractDetail/create";
    }

    @PostMapping("/save")
    public String createCustomerType(@Valid @ModelAttribute ContractDetail customerType, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contractList", contractService.findAll());
            model.addAttribute("attachServiceList", attachServiceDAO.findAll());
            return "/contractDetail/create";
        } else {
            contractDetailService.save(customerType);
            redirectAttributes.addFlashAttribute("message", "create success!!!");
            return "redirect:/contractDetail";
        }
    }

    @GetMapping("/{id}/update")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        ContractDetail customerType = contractDetailService.findById(id);
        model.addAttribute("contractList", contractService.findAll());
        model.addAttribute("attachServiceList", attachServiceDAO.findAll());
        model.addAttribute("customerType", customerType);
        return "/contractDetail/edit";
    }

    @PostMapping("/update")
    public String editCustomerType(@Valid @ModelAttribute ContractDetail customerType, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contractList", contractService.findAll());
            model.addAttribute("attachServiceList", attachServiceDAO.findAll());
            return "/contractDetail/edit";
        } else {
            contractDetailService.save(customerType);
            redirectAttributes.addFlashAttribute("message", "update success!!!");
            return "redirect:/contractDetail";
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteCustomerType(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        contractDetailService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete success!!!!");
        return "redirect:/contractDetail";
    }

}
