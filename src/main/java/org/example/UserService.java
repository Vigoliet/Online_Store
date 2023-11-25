package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private String currentUser;
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();

    private boolean isLoggedIn() {
        return currentUser != null;
    }

    public void registerUser(Scanner scanner){


        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        // Check if the username already exists
        if (usernames.contains(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        // Add the new user to the ArrayLists
        usernames.add(username);
        passwords.add(password);

        System.out.println("User registered successfully!");
    }

    public void login(Scanner scanner){
        if (isLoggedIn()) {
            System.out.println("You are already logged in. Logout first to login with a different user.");
            return;
        }

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if the username and password match
        int index = usernames.indexOf(username);
        // -1 is if specified element does not exit
        if (index != -1 && passwords.get(index).equals(password)) {
            currentUser = username;
            System.out.println("Login successful. Welcome, " + username + "!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    public void printRegisteredUsers() {
        System.out.println("Registered Users:");

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
