package vn.codegym.service;

import vn.codegym.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findAll();

    Cart findById(int id);

    void save(Cart cart);

    void remove(int id);

}
