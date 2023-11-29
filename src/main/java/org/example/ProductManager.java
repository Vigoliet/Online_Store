package org.example;

import java.util.ArrayList;


public class ProductManager {

    public ProductManager() {
        this.shoppingCart = new ArrayList<>();
    }

    ArrayList<Product> shoppingCart;

    public void addProductToCart(Product product) {
        shoppingCart.add(product);
    }

    public void removeProductFromCart(Product product) {
        shoppingCart.remove(product);
    }

    public void printCart() {
        for (Product product : shoppingCart) {
            System.out.println(product);
        }
    }




}
