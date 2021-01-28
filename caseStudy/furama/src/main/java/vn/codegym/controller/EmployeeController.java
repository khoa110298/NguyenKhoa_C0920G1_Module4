package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.Customer;
import vn.codegym.entity.Employee;
import vn.codegym.service.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    PositionService positionService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    UserService userService;

    @GetMapping({"", "/list"})
    public String listEmployee(Model model, @RequestParam Optional<String> keyword, @PageableDefault(value = 5) Pageable pageable) {
        String keywordOld = "";
        if (!keyword.isPresent()) {
            model.addAttribute("employeeList", employeeService.findAll(pageable));
            return "/employee/list";
        } else {
            keywordOld = keyword.get();
            model.addAttribute("employeeList", employeeService.findAllByName(keywordOld, pageable));
            model.addAttribute("keywordOld", keywordOld);
            return "/employee/list";
        }


    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/save")
    public String createEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("positionList", positionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("userList", userService.findAll());
            return "employee/create";
        } else {
            String id = employee.getId();
            boolean check = true;
            for (Employee em : employeeService.findAll()) {
                if (id.equals(em.getId())) {
                    check = false;
                    break;
                }
            }
            if (check) {
                employeeService.save(employee);
                redirectAttributes.addFlashAttribute("message", "create success!!!");
                return "redirect:/employee/list";
            } else {
                model.addAttribute("message1", "id đã tồn tại!!!");
                model.addAttribute("positionList", positionService.findAll());
                model.addAttribute("educationDegreeList", educationDegreeService.findAll());
                model.addAttribute("divisionList", divisionService.findAll());
                model.addAttribute("userList", userService.findAll());
                return "employee/create";
            }
        }
    }

    @GetMapping("/{id}/view")
    public String employeeDetail(@PathVariable("id") String id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "/employee/view";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
        employeeService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete success!!!");
        return "redirect:/employee/list";
    }

    @GetMapping("/{id}/update")
    public String showUpdateEmployee(@PathVariable("id") String id, Model model) {
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/edit";
    }

    @PostMapping("/update")
    public String updateeEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("positionList", positionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("userList", userService.findAll());
            return "/employee/edit";
        } else {
            String idEmp = employee.getId();
            boolean check = false;
            for (Employee em : employeeService.findAll()) {
                if (idEmp.equals(em.getId())) {
                    check = true;
                    break;
                }
            }
            if (check) {
                employeeService.save(employee);
                redirectAttributes.addFlashAttribute("message", "update success!!!");
                return "redirect:/employee/list";
            } else {
                model.addAttribute("positionList", positionService.findAll());
                model.addAttribute("educationDegreeList", educationDegreeService.findAll());
                model.addAttribute("divisionList", divisionService.findAll());
                model.addAttribute("userList", userService.findAll());
                model.addAttribute("message", "id không tồn tại !!!");
                return "/employee/edit";
            }
        }
    }
}
