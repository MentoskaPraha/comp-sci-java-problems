package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;

public class EvenAndOddCounter extends Assignment {

  public EvenAndOddCounter(){
    this.name = "Even and Odd Counter";
  }

  @Override
  public void run (){
    //print intro message
    System.out.println("Welcome to the Even And Odd Counter Program 3000000 (because 3000 wasn't enough)!\nFirst tell us how many integers you want to check, then input them, after which\nthis program will tell you how many are even and how many are odd.");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //get data
      int numNumbers = TextInput.integerInput("Please input the number of integers: ", null);
      int[] numbers = TextInput.multiIntegerInput(numNumbers, "You're inputting " + numNumbers + " numbers.", null);

      // count odd or even
      int odd = 0;
      int even = 0;
      for(int number : numbers){
        if(number % 2 == 0){
          even++;
        } else {
          odd++;
        }
      }

      //print result
      System.out.println("Number of even integers: " + even + "\nNumber of odd integers: " + odd);

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Would you like to check another list of integers?", null);
    }

    System.out.println("Goodbye!");
  }
}
