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

    public void removeProductFromCart(int productId) {
        for (Product product : shoppingCart) {
            if (product.getId() == productId) {
                shoppingCart.remove(product);
                return; // Once removed, exit the method
            }
        }
        System.out.println("Product with ID " + productId + " not found in the cart.");
    }

    public void printCart() {
        for (Product product : shoppingCart) {
            System.out.println(product);
        }
    }

    public void checkout() {
        double total = 0;
        for (Product product : shoppingCart) {
            total += product.getPrice();
        }
        System.out.println("Total: " + total);
    }




}
