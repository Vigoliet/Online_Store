package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Print all registered users");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    userService.registerUser(scanner);
                    break;
                case 2:
                    userService.login(scanner);
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