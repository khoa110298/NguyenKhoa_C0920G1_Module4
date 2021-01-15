package vn.codegym.demo.service;

import vn.codegym.demo.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(int id);


}
