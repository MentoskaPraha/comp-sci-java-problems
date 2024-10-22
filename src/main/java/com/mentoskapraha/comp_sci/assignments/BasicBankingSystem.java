package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;
import com.mentoskapraha.comp_sci.common.TextMenu;

public class BasicBankingSystem extends Assignment {
  public BasicBankingSystem(){
    this.name = "Basic Banking System";
  }

  private int balance = 100;

  @Override
  public void run(){
    //print intro message
    System.out.println("Welcome to the Basic Banking System Program 3000000 (because 3000 wasn't enough)!\nYou can check your balance, deposit or withdraw money and that's pretty much it.");

    //define a menu
    TextMenu menu = new TextMenu(
            "What would you like to do?",
            "Make a selection: ",
            "Invalid selection! Try again: ",
            "Exit",
            "Check Balance",
            "Deposit",
            "Withdrawal"
    );

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //display the menu
      int selection = menu.display();

      //run correct code based on user selection
      switch (selection){
        case 1: {
          //print out the balance of the user
          System.out.println("You currently have " + balance + " units in your account.");
          TextInput.pressEnterToContinue(null);
          break;
        }
        case 2: {
          deposit();
          break;
        }
        case 3: {
          withdrawal();
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

  private void deposit(){
    //get deposit amount
    int amount = 0;
    boolean success = false;
    while(!success){
      //prompt user of input
      amount = TextInput.integerInput("Please input the deposit amount: ", "Invalid deposit amount. Try again: ");

      //ensure amount is not negative
      if(amount < 1){
        System.out.println("Deposit amount cannot be less than one! Please try again.");
      } else {
        success = true;
      }
    }

    //add deposit to balance
    balance += amount;

    //tell the user success
    System.out.println("Success!");
    TextInput.pressEnterToContinue(null);
  }

  private void withdrawal(){
    //get withdrawal amount
    int amount = 0;
    boolean success = false;
    while(!success){
      //prompt user of input
      amount = TextInput.integerInput("Please input the withdrawal amount: ", "Invalid withdrawal amount. Try again: ");

      //ensure the user has the funds
      if((balance - amount) < 0){
        System.out.println("Insufficient Funds! Please try again.");
      } else {
        success = true;
      }
    }

    //remove withdrawal amount from balance
    balance -= amount;

    //tell the user success
    System.out.println("Success!");
    TextInput.pressEnterToContinue(null);
  }
}
