package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.entity.Cart;
import vn.codegym.repository.CartRepository;
import vn.codegym.service.CartService;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;
    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(int id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void remove(int id) {
        cartRepository.deleteById(id);
    }
}
