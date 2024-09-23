package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;
import com.mentoskapraha.comp_sci.common.TextMenu;
import com.mentoskapraha.comp_sci.common.User;

import java.util.ArrayList;

public class SimpleLoginSystem extends Assignment {

  public SimpleLoginSystem(){
    this.name = "Simple Login System";
  }

  @Override
  public void run (){
    //create the text menu
    TextMenu menu = new TextMenu(
            "Welcome to the Simple Login Program Program 3000000 (because 3000 wasn't enough)!\nWhat would you like to do?",
            "Please make a selection:",
            "Invalid Input :)\nPlease try again: ",
            "Exit",
            "Login", "Signup", "Forgot your password?"
    );

    //An arraylist to store all users.
    ArrayList<User> users = new ArrayList<>();

    //Ask what the user what they want to do and then do. Repeat until they exit.
    boolean exit = false;
    while(!exit) {
      int choice = menu.display();
      switch (choice){
        case 1: {
          login(users);
          break;
        }
        case 2: {
          users.add(signup(users));
          TextInput.pressEnterToContinue("Press Enter to return to menu...");
          break;
        }
        case 3: {
          resetPassword(users);
          break;
        }
        default: {
          exit = true;
          break;
        }
      }
    }

    System.out.println("Goodbye!");
  }

  private static void login(ArrayList<User> users) {
    System.out.println("Commencing login...");

    //get the user
    User user = getUser(users);

    //inform the user if the user doesn't exist
    if(user == null) {
      System.out.println("The username you entered doesn't exist!\nAborting...");
      TextInput.pressEnterToContinue("Press Enter to return to menu...");
      return;
    }

    //login the user
    boolean success = user.login(
            TextInput.stringInput("Please input your password: ", "Password cannot be empty or blank!\n Please try again: ")
    );

    //tell the user whether they've logged in or not
    if(success){
      TextInput.pressEnterToContinue("You have been logged in!\nPress enter to logout...");
    } else {
      System.out.println("Incorrect Password!");

      //ask whether the user wants to reset their password
      boolean resetPass = TextInput.yesNoInput(false, "Would you like to reset your password?", null);
      if(resetPass) {
        resetPassword(users);
      } else {
        System.out.println("Login Failed! Aborting...");
        TextInput.pressEnterToContinue("Press Enter to return to menu...");
      }
    }
  }

  private static void resetPassword(ArrayList<User> users) {
    System.out.println("Commencing password reset...");

    //get the user
    User user = getUser(users);

    //inform the user if the user doesn't exist
    if(user == null) {
      System.out.println("The username you entered doesn't exist!\nAborting...");
      TextInput.pressEnterToContinue("Press Enter to return to menu...");
      return;
    }

    //inform the user if the account recovery feature is disabled on the user
    if(!user.recovery){
      System.out.println("The user you entered doesn't have the recovery feature enabled making recovery impossible!\nAborting...");
      TextInput.pressEnterToContinue("Press Enter to return to menu...");
      return;
    }

    //reset the users password
    int status = user.resetPassword(
            TextInput.integerInput("Input your recovery code: ", "The recovery code must be a number!\nPlease try again: "),
            TextInput.newPasswordInput("Warning: Your new password which mustn't match old password!")
    );

    //let the user know how the password reset went
    switch (status){
      case 0: {
        System.out.println("The user you entered doesn't have the recovery feature enabled making recovery impossible!\nAborting...");
        TextInput.pressEnterToContinue("Press Enter to return to menu...");
        break;
      }
      case 1: {
        System.out.println("The recovery code is incorrect!\nAborting...");
        TextInput.pressEnterToContinue("Press Enter to return to menu...");
        break;
      }
      case 2: {
        System.out.println("The new password mustn't matches the old password!\nAborting...");
        TextInput.pressEnterToContinue("Press Enter to return to menu...");
      }
      default: {
        System.out.println("Successfully Reset Password for " + user.username + "!\nYour new recovery code is: " + status);
        TextInput.pressEnterToContinue("Press Enter to return to menu...");
      }
    }
  }

  private static User signup(ArrayList<User> users) {
    System.out.println("Creating a new account...");

    //ensure the user inputs a unique username
    boolean uniqueUsername = false;
    String username = "";
    String prompt = "Please input your username: ";
    while(!uniqueUsername){
      username = TextInput.stringInput(prompt, "Username cannot be blank or empty!\nPlease try again: ");

      if(users.isEmpty()) break;
      uniqueUsername = true;
      for (User user : users){
        if(user.username.matches(username)){
          prompt = "That user already exists!\nPlease try another username: ";
          uniqueUsername = false;
          break;
        }
      }
    }

    //create the user
    User result = new User(
            username,
            TextInput.newPasswordInput("Create a password.\nThe password must contain at least one special character, at least one\nnumber, at least one capital character and must be at least 12\ncharacters long.")
    );

    //enable account recovery
    System.out.println("Please choose if you wish to enable account recovery,\nso that you can recover your account if you forget your password.");
    if (TextInput.yesNoInput(true, "Enable account recovery?",null)){
      System.out.println("Enabled account recovery!\nPlease write down your recovery code, which is: " + result.enableRecovery());
    } else {
      System.out.println("Account recovery will remain disabled.");
    }

    System.out.println("Account Successfully Created!");

    return result;
  }

  /**
   * Gets a user from the provided ArrayList.
   * @param users The list of users to search
   * @return The user, if any, null if there isn't any.
   */
  private static User getUser(ArrayList<User> users){
    String username = TextInput.stringInput("Please input your username: ", "Username cannot be blank or empty!\nPlease try again: ");
    User user = null;
    for(User potentialUser : users) {
      if(potentialUser.username.matches(username)) {
        user = potentialUser;
        break;
      }
    }

    return user;
  }
}
