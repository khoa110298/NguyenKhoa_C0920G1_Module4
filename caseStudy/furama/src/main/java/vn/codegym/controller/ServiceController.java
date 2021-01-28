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
import vn.codegym.entity.ServiceEntity;
import vn.codegym.service.RentTypeService;
import vn.codegym.service.ServiceDAO;
import vn.codegym.service.ServiceTypeDAO;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceDAO serviceDAO;
    @Autowired
    ServiceTypeDAO serviceTypeDAO;
    @Autowired
    RentTypeService rentTypeService;

    @GetMapping({"", "/list"})
    public String listService(Model model, @RequestParam Optional<String> keyword, @PageableDefault(value = 5) Pageable pageable) {
        String keywordOld = "";
        if (!keyword.isPresent()) {
            model.addAttribute("serviceList", serviceDAO.findAll(pageable));
            return "/service/list";
        } else {
            keywordOld = keyword.get();
            model.addAttribute("serviceList", serviceDAO.findAllInputText(keywordOld, pageable));
            model.addAttribute("keywordOld", keywordOld);
            return "/service/list";
        }

    }

    @GetMapping("/create")
    public String showCreateService(Model model) {
        model.addAttribute("serviceTypeList", serviceTypeDAO.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("service", new ServiceEntity());
        return "/service/create";
    }

    @PostMapping("/save")
    public String createService(@Valid @ModelAttribute("service") ServiceEntity serviceEntity, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("serviceTypeList", serviceTypeDAO.findAll());
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            return "/service/create";
        } else {
            String id = serviceEntity.getId();
            boolean check = true;
            for (ServiceEntity cus : serviceDAO.findAll()) {
                if (id.equals(cus.getId())) {
                    check = false;
                    break;
                }
            }
            if (check) {
                serviceDAO.save(serviceEntity);
                redirectAttributes.addFlashAttribute("message", "create success!!!");
                return "redirect:/service/list";
            } else {
                model.addAttribute("message1", "id đã tồn tại!!");
                model.addAttribute("serviceTypeList", serviceTypeDAO.findAll());
                model.addAttribute("rentTypeList", rentTypeService.findAll());
                return "service/create";
            }
        }

    }

    @GetMapping("/{id}/view")
    public String serviceDetail(@PathVariable("id") String id, Model model) {
        ServiceEntity serviceEntity = serviceDAO.findById(id);
        model.addAttribute("service", serviceEntity);
        return "/service/view";
    }

    @GetMapping("/{id}/delete")
    public String deleteService(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        serviceDAO.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete success!!!");
        return "redirect:/service/list";
    }

    @GetMapping("/{id}/update")
    public String showUpdateService(@PathVariable("id") String id, Model model) {
        model.addAttribute("serviceTypeList", serviceTypeDAO.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("service", serviceDAO.findById(id));
        return "/service/edit";
    }

    @PostMapping("/update")
    public String updateService(@Valid @ModelAttribute("service") ServiceEntity serviceEntity, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("serviceTypeList", serviceTypeDAO.findAll());
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            return "/service/edit";
        } else {
            String idSer = serviceEntity.getId();
            boolean check = false;
            for (ServiceEntity cus : serviceDAO.findAll()) {
                if (idSer.equals(cus.getId())) {
                    check = true;
                    break;
                }
            }
            if (check) {
                serviceDAO.save(serviceEntity);
                redirectAttributes.addFlashAttribute("message", "update success!!!");
                return "redirect:/service/list";
            } else {
                model.addAttribute("serviceTypeList", serviceTypeDAO.findAll());
                model.addAttribute("rentTypeList", rentTypeService.findAll());
                model.addAttribute("message", "id không tồn tại !!!");
                return "/service/edit";
            }
        }
    }

}
