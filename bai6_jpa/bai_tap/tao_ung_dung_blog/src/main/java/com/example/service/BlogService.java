package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void update(Blog blog);

    void remove(int id);

    void insertProduct(Blog blog);
}
