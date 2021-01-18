package vn.codegym.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.demo.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    List<Blog> sortWriteDate(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);

    Page<Blog> findAllInputText(String name, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);


    int getTotalPages();
}
