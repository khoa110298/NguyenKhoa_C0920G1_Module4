package vn.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DoiTien {
    @RequestMapping(value = "calculate",method = RequestMethod.GET)
    public String getMoney(HttpServletRequest request, Model model){
        String type = request.getParameter("type");
        String money = request.getParameter("money");
        try {
            if (type.equals("usd")){
                model.addAttribute("result",Double.parseDouble(money)*22000);
            }else {
                model.addAttribute("result",Double.parseDouble(money)/22000);
            }
        }catch (NumberFormatException e){
            model.addAttribute("message","error");
        }
        return "show";
    }
}
