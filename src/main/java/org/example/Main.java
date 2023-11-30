package org.example;

import java.util.List;
import java.util.Scanner;


public class Main {
    private static final UserService userService = new UserService();
    public static void main(String[] args) {

        //initialProducts();
        runProgram();
        runStore();

    }

    private static void runProgram() {
        while (userService.CurrentUser() == null ){
            try {
                var inputOption = mainMenu();

                handleInputOption(inputOption);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void runStore() {
        // todo add menu for store & logout
        // print available products
        // print cart
        // Checkout
        // logout (send runProgram() and currentUser = null)
        System.out.println("Test");
    }

    private static void handleInputOption(int inputOption) {
        switch (inputOption){
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

    private static int mainMenu() {
        printMainMenu();
        return getMenuOption();
    }

    private static int getMenuOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void printMainMenu() {
        System.out.println("1. Register \n" +
                "2. Login\n" +
                "3. Print all registered users\n" +
                "4. Exit");
    }

    private static void initialProducts(){
        ProductManager productManager = new ProductManager();
        Product [] products;

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
    }

}