package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.TextMenu;

import java.io.Console;

public class SimpleLoginSystem {
  public static void main (String[] args){
    TextMenu menu = new TextMenu(
            "Welcome to the Simple Login Program Program 3000000 (because 3000 wasn't enough)!\nWhat would you like to do?",
            "Please make a selection:",
            "Invalid Input :)\nPlease try again: ",
            "Exit",
            "Signup", "Login", "Forgot your password?"
    );

    boolean exit = false;
    while(!exit) {
      int choice = menu.display();
      switch (choice){
        case 1: {
          throw new UnsupportedOperationException("The login functionality is not implemented yet.");
        }
        case 2: {
          throw new UnsupportedOperationException("The signup functionality is not implemented yet.");
        }
        case 3: {
          throw new UnsupportedOperationException("The \"Forgot your password?\" functionality is not implemented yet.");
        }
        default: {
          exit = true;
          break;
        }
      }
    }

    System.out.println("Goodbye!\nProgram exited with Exit Code 0");
  }
}
