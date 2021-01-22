package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.Customer;
import vn.codegym.entity.Employee;
import vn.codegym.service.DivisionService;
import vn.codegym.service.EducationDegreeService;
import vn.codegym.service.EmployeeService;
import vn.codegym.service.PositionService;

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

    @GetMapping({"","/list"})
    public String listEmployee(Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("employeeList",employeeService.findAll(pageable));
        return "/employee/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("positionList",positionService.findAll());
        model.addAttribute("educationDegreeList",educationDegreeService.findAll());
        model.addAttribute("divisionList",divisionService.findAll());
        model.addAttribute("employee",new Employee());
        return "employee/create";
    }
    @PostMapping("/save")
    public String createEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes){

        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message","create success!!!");
        return "redirect:/employee";
    }
    @GetMapping("/{id}/view")
    public String employeeDetail(@PathVariable("id") String id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "/employee/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteEmployee(@PathVariable("id") String id,RedirectAttributes redirectAttributes){
        employeeService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete success!!!");
        return "redirect:/employee";
    }
    @GetMapping("/{id}/update")
    public String showUpdateEmployee(@PathVariable("id") String id,Model model){
        model.addAttribute("positionList",positionService.findAll());
        model.addAttribute("educationDegreeList",educationDegreeService.findAll());
        model.addAttribute("divisionList",divisionService.findAll());
        model.addAttribute("employee",employeeService.findById(id));
        return "/employee/edit";
    }
    @PostMapping("/update")
    public String updateeEmployee(@ModelAttribute Employee employee,RedirectAttributes redirectAttributes,Model model){
        String idEmp = employee.getId();
        boolean check = false;
        for (Employee em:employeeService.findAll()) {
            if (idEmp.equals(em.getId())) {
                check = true;
                break;
            }
        }
        if (check) {
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "update success!!!");
            return "redirect:/employee";
        }else {
            model.addAttribute("positionList",positionService.findAll());
            model.addAttribute("educationDegreeList",educationDegreeService.findAll());
            model.addAttribute("divisionList",divisionService.findAll());
            model.addAttribute("message","id không tồn tại !!!");
            return "/employee/edit";
        }
    }
    @PostMapping("/search")
    public String findByNameEmployee(@RequestParam String keyword, @PageableDefault(value = 5)Pageable pageable,Model model){
        model.addAttribute("employeeList",employeeService.findAllByName(keyword,pageable));
        return "/employee/list";
    }
}
