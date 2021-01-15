package vn.codegym.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vn.codegym.demo.model.Blog;
import vn.codegym.demo.service.BlogService;
import vn.codegym.demo.service.CategoryService;

import java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    BlogService blogService;

    @GetMapping("/api/blog")
    public ResponseEntity<List<Blog>> listBlog(){
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/api/blog/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable("id") int id){
        Blog blog = blogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
