package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();

        productMap.put(1, new Product(1, "nokia1080", 2000000, "Microsoft","/img/anh1.jpg"));
        productMap.put(2, new Product(2, "tu lanh", 6000000, "Toshiba","/img/anh2.jpg"));
        productMap.put(3, new Product(3, "winner", 50000, "honda","/img/anh3.jpg"));
        productMap.put(4, new Product(4, "iphone8", 100000, "Apple","/img/anh4.jpg"));
        productMap.put(5, new Product(5, "exciter", 300000000, "yamaha","/img/anh5.jpg"));
    }
    @Override
    public List<Product> selectAllProduct() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product selectProductById(int id) {
        return productMap.get(id);
    }

    @Override
    public void insertProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void updateProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(int id) {
        productMap.remove(id);
    }
}
