# Assignment: Online store

## How to run the code

1. Pull the code from [Github](https://github.com/Vigoliet/Online_Store)
2. Open the project in Intellij IDEA
3. Run `Main()` from `org.example`

>When starting the project make sure files are not corrupt. <br> <br> If everything
>is fine after pulling down the project you should be good to go.

## Project Structure

### `Main.java`
This file is the entry point and will call all the necessary methods for the console
program.

### `Product.java`
Class for the products that will be sold in the store.

### `ProductManager.java`
Class to handle the products in the store.

### `User.java`
Class for the users that will be registered in the store.

### `UserService.java`
Class for handling the users that will be registered in the store.

## Implementation of store functionality and user registration
- With the console we have a main menu that will be the entry point for the user.
- From there they can choose to register a new user or login with an existing user.
- If they choose to register a new user they will be prompted to enter a username and password. 
- If they choose to login they will be prompted to enter their username and password. If they enter the correct credentials 
they will be logged in and be able to access the store.
- If they enter the wrong credentials they will be prompted to try again.
- When logged in - the user will be able to see the products in the store and choose to buy one of them.
- If they choose to add a product to their cart, they will be prompted to enter the ID of the product they want to buy.
- If the product does not exist in the store or the user does not have enough money to buy it they will be prompted to try again.

