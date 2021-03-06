package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> selectAllProduct();

    Product selectProductById(int id);

    void insertProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);
}
