package vn.codegym.entity;


import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Product product;

    public Cart() {
    }

    public Cart(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Map<Product, Integer> cart = new HashMap<>();

    public void addToCart(Product product){
        if(cart.containsKey(product)){
            cart.replace(product,cart.get(product),cart.get(product)+1);
        }else {
            cart.put(product,1);
        }
    }
    public void removeProduct(Product product){
        cart.remove(product);
    }
    public int getAmount(Product product){
        return cart.get(product);
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }
}
