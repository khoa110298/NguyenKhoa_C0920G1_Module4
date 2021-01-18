package vn.codegym.service;

import vn.codegym.entity.Cart;
import vn.codegym.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void remove(int id);
}
