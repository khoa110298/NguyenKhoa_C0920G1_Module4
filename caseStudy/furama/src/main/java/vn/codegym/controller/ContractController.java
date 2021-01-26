package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.Contract;
import vn.codegym.entity.Customer;
import vn.codegym.service.ContractService;
import vn.codegym.service.CustomerService;
import vn.codegym.service.EmployeeService;
import vn.codegym.service.ServiceDAO;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    CustomerService customerService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ServiceDAO serviceDAO;
    @Autowired
    ContractService contractService;

    @GetMapping({"", "/list"})
    public String listContract(Model model, @RequestParam Optional<String> keyword, @PageableDefault(value = 5) Pageable pageable) {
        String search = "";
        if (!keyword.isPresent()) {
            model.addAttribute("contractList", contractService.findAll(pageable));
            return "/contract/list";
        } else {
            search = keyword.get();
            model.addAttribute("contractList", contractService.findAllInputText(search, pageable));
            model.addAttribute("search", search);
            return "/contract/list";
        }

    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("serviceList", serviceDAO.findAll());
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }

    @PostMapping("/save")
    public String createContract(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerList", customerService.findAll());
            model.addAttribute("employeeList", employeeService.findAll());
            model.addAttribute("serviceList", serviceDAO.findAll());
            return "contract/create";
        } else {
            String id = contract.getId();
            boolean check = true;
            for (Contract contract1 : contractService.findAll()) {
                if (id.equals(contract1.getId())) {
                    check = false;
                    break;
                }
            }
            if (check) {
                contractService.save(contract);
                redirectAttributes.addFlashAttribute("message", "create success!!!");
                return "redirect:/contract/list";
            } else {
                model.addAttribute("customerList", customerService.findAll());
                model.addAttribute("employeeList", employeeService.findAll());
                model.addAttribute("serviceList", serviceDAO.findAll());
                model.addAttribute("messageId", "id đã tồn tại!!!");
                return "contract/create";
            }
        }

    }

    @GetMapping("/{id}/view")
    public String contractDetail(@PathVariable("id") String id, Model model) {
        Contract contract = contractService.findById(id);
        model.addAttribute("contract", contract);
        return "/contract/view";
    }

    @GetMapping("/{id}/delete")
    public String deleteContract(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        contractService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete success!!!");
        return "redirect:/contract/list";
    }

    @GetMapping("/{id}/update")
    public String showUpdateContract(@PathVariable("id") String id, Model model) {
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("serviceList", serviceDAO.findAll());
        model.addAttribute("contract", contractService.findById(id));
        return "/contract/edit";
    }

    @PostMapping("/update")
    public String updateContract(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerList", customerService.findAll());
            model.addAttribute("employeeList", employeeService.findAll());
            model.addAttribute("serviceList", serviceDAO.findAll());
            return "/contract/edit";
        } else {
            String idContract = contract.getId();
            boolean check = false;
            for (Contract contract1 : contractService.findAll()) {
                if (idContract.equals(contract1.getId())) {
                    check = true;
                    break;
                }
            }
            if (check) {
                contractService.save(contract);
                redirectAttributes.addFlashAttribute("message", "update success!!!");
                return "redirect:/contract/list";
            } else {
                model.addAttribute("customerList", customerService.findAll());
                model.addAttribute("employeeList", employeeService.findAll());
                model.addAttribute("serviceList", serviceDAO.findAll());
                model.addAttribute("messageId", "id không tồn tại !!!");
                return "/contract/edit";
            }
        }
    }
}
