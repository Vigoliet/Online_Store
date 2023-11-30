package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final UserService userService = new UserService();
    private static final ProductManager productManager= new ProductManager();
    public static void main(String[] args) {
        runProgram();
        runStore();

    }

    private static void runProgram() {
        while (userService.CurrentUser() == null ){
            try {
                var inputOption = mainMenu("1. Register \n" +
                        "2. Login\n" +
                        "3. Print all registered users\n" +
                        "4. Exit");

                handleInputOption(inputOption);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void runStore() {
        // todo add menu for store & logout
        // print available products
        // view cart // remove from cart // if statement if cart is empty
        // checkout
        // add to cart // Based on id
        while (userService.CurrentUser() != null ){
            try {
                var inputOption = mainMenu("1. Available products \n" +
                        "2. View cart\n" +
                        "3. Add to cart\n" +
                        "4. Checkout \n" +
                        "5. Logout");

                handleInputOptionStore(inputOption);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }    }

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
    private static void handleInputOptionStore(int inputOption) {
        switch (inputOption){
            case 1:
                System.out.println("\n---Available products---");
                System.out.println((initialProducts()));
                break;
            case 2:
                System.out.println("\n---View cart---");
                productManager.printCart();
                break;
            case 3:
                System.out.println("\n---Add item to cart---");
                break;
            case 4:
                System.out.println("\n---Checkout---");
                break;
            case 5:
                System.out.println("\n---Logout---");
                userService.logout();
                runProgram();
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static int mainMenu(String string) {
        printMainMenu(string);
        return getMenuOption();
    }

    private static int getMenuOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void printMainMenu(String string) {
        System.out.println(string);
    }

    private static ArrayList<Product> initialProducts(){
        Product.resetID(); // Reset the nextID before creating initial products
        // Create an array of Product objects
        ArrayList<Product> availableProducts = new ArrayList<>(Arrays.asList(
                new Product("Laptop", 999.99, "Electronics"),
                new Product("Headphones", 49.99, "Electronics"),
                new Product("Backpack", 39.99, "Fashion"),
                new Product("Running Shoes", 79.99, "Sportswear")
                // Add more products as needed
        ));
        return availableProducts;
        /*productManager.addProductToCart(availableProducts[0]);
        productManager.printCart(); */
    }

}