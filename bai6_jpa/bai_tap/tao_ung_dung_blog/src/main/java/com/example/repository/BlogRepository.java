package com.example.repository;

import com.example.model.Blog;

import java.util.List;

public interface BlogRepository {
    List<Blog> findAll();

    Blog findById(int id);

    void update(Blog blog);

    void remove(int id);

    void insertProduct(Blog blog);
}
