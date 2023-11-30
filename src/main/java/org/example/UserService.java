package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    private ArrayList<User> users = new ArrayList<>();
    private String currentUser;
    //private Scanner scanner = new Scanner(System.in);

    private boolean isLoggedIn() {
        return currentUser != null;
    }

    public static User getDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");

        String username = scanner.nextLine();

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        return new User(username, password);
    }

    public void registerUser(User user) {
        if (isLoggedIn()) {
            System.out.println("You are already logged in. Logout first to register a new user.");
            return;
        }

        // Check if the username already exists
        if (users.contains(user)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        // Add the new user to the ArrayList
        users.add(user);

        System.out.println("User registered successfully!");
    }

    public void login(User user) {
        if (isLoggedIn()) {
            System.out.println("You are already logged in. Logout first to login with a different user.");
            return;
        }

        // Check if the user exists in the ArrayList
        if (users.contains(user)) {
            // Find the actual user object in the list
            User actualUser = users.get(users.indexOf(user));

            // Check if the entered password matches the stored password
            if (actualUser.getPassword().equals(user.getPassword())) {
                currentUser = actualUser.getUsername();
                System.out.println("Login successful. Welcome, " + currentUser + "!");
            } else {
                System.out.println("Invalid password. Please try again.");
            }
        } else {
            System.out.println("User not found. Please try again.");
        }
    }

    public String CurrentUser(){
        return currentUser;
    }

    public void printRegisteredUsers() {
        System.out.println("Registered Users:");
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }
}
