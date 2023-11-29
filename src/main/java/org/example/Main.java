package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();

        // Create an array of Product objects
        Product[] availableProducts = {
                new Product("Laptop", 999.99, "Electronics"),
                new Product("Headphones", 49.99, "Electronics"),
                new Product("Backpack", 39.99, "Fashion"),
                new Product("Running Shoes", 79.99, "Sportswear")
                // Add more products as needed
        };
        
        productManager.addProductToCart(availableProducts[0]);
        productManager.printCart();



        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();

        while (true){
            System.out.println("1. Register \n" +
                    "2. Login\n" +
                    "3. Print all registered users\n" +
                    "4. Exit");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    User newUser = UserService.getDetails();
                    userService.registerUser(newUser);
                    break;
                case 2:
                    User loginUser = UserService.getDetails();
                    userService.login(loginUser);
                    break;
                case 3:
                    userService.printRegisteredUsers();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        }

    }

}