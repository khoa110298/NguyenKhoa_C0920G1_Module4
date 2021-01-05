package com.example.service;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public List<String> languageEmail() {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        return languageList;
    }

    @Override
    public List<Integer> pageEmail() {
        List<Integer> pageList = new ArrayList<>();
        pageList.add(5);
        pageList.add(10);
        pageList.add(15);
        pageList.add(25);
        pageList.add(50);
        pageList.add(100);
        return pageList;
    }
}
