package com.example.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryServiceIpl implements DictionaryService  {
    private static Map<String,String> dictionaryList;
    static {
        dictionaryList = new HashMap<>();
        dictionaryList.put("one","một");
        dictionaryList.put("two","hai");
        dictionaryList.put("three","ba");
        dictionaryList.put("four","bốn");
        dictionaryList.put("five","năm");
        dictionaryList.put("six","sáu");
        dictionaryList.put("seven","bảy");
        dictionaryList.put("eight","tám");
        dictionaryList.put("nine","chín");
        dictionaryList.put("ten","mười");
        dictionaryList.put("hello","xin chào");
    }
    @Override
    public String search(String keyWord) {
        return dictionaryList.get(keyWord);
    }
}
