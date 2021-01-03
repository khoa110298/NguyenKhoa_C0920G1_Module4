package com.example.controller;

import com.example.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class Dictionary {
    @Autowired
    DictionaryService dictionaryService;
    @RequestMapping(value = "/dictionary",method = RequestMethod.GET)
    public String getKeyWord(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        String keyWord = request.getParameter("keyWord");
        if (dictionaryService.search(keyWord) == null){
            model.addAttribute("vietNam",keyWord);
            model.addAttribute("message","Not Find");
        }else {
            model.addAttribute("english",dictionaryService.search(keyWord));
            model.addAttribute("vietNam",keyWord);
        }
        return "/show";
    }
}
