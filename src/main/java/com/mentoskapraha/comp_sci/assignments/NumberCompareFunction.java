package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;

public class NumberCompareFunction extends Assignment {
  public NumberCompareFunction(){
    this.name = "Number Compare Function";
  }

  @Override
  public void run(){
    //print intro message
    System.out.println("Welcome to the Number Compare Function Program 3000000 (because 3000 wasn't enough)!\nInput two numbers and this program will use a function to determine whether\nthe first number is smaller or larger than the second.");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //get user input
      int a = TextInput.integerInput("Input the first number: ", null);
      int b = TextInput.integerInput("Input the second number: ", null);

      //Out put the comparison
      System.out.println("The first number (" + a + ") is " + compareNumbers(a, b) + " than the second number (" + b + ").");

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Do you wish to compare another pair of numbers?", null);
    }

    System.out.println("Goodbye!");
  }

  /**
   * This function will compare two numbers and determine whether the first
   * is smaller or larger than the second.
   * @param first The first number.
   * @param second The number to compare the first to.
   * @return A string that says 'smaller' if the first number is smaller or 'larger' if it's larger.
   */
  private String compareNumbers(int first, int second){
    if(first > second) {
      return "larger";
    } else {
      return "smaller";
    }
  }
}
