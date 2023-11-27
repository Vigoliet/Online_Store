package org.example;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

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
                    //System.out.println(loginUser);
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