package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;

public class FibonacciGenerator extends Assignment {

  public FibonacciGenerator(){
    this.name = "Fibonacci Generator";
  }

  @Override
  public void run(){
    //print intro message
    System.out.println("Welcome to the Fibonacci Generator Program 3000000 (because 3000 wasn't enough)!\nGenerates a Fibonacci Sequence up to the specified number of terms.\nThe maximum amount of terms is 47 (anything larger cause variable overflow lol)");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //get the user input, ensuring length is less than 43
      int length = 0;
      boolean success = false;
      while(!success) {
        length = TextInput.integerInput("Input the number of terms in the sequence: ", null);
        if(length <= 47){
          success = true;
          System.out.println("Calculating Sequence...");
        } else {
          System.out.println("Number of terms cannot exceed 47! Please try again.");
        }
      }

      //calculate the sequence
      int[] sequence = new int[length];

      //first initialise the first two values at 0 and 1
      sequence[0] = 0;
      sequence[1] = 1;

      /*
        Now loop through the sequence starting at index 2
        and make the index the sum of the previous 2 indexes.
       */
      for(int i = 2; i < sequence.length; i++){
        sequence[i] = sequence[i - 2] + sequence[i - 1];
      }

      /*
        Format the sequence into a string so that each line contains
        10 numbers.
       */
      StringBuilder results = new StringBuilder();
      results.append("Here is your sequence:\n");
      for(int i = 0; i < sequence.length; i++){
        results.append(sequence[i]);
        if((i + 1) != sequence.length){
          if((i + 1) % 10 == 0) {
            results.append("\n");
          } else {
            results.append("  ");
          }
        }
      }

      //print out sequence
      System.out.println(results);

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Do you to generate another sequence?", null);
    }

    System.out.println("Goodbye!");
  }
}
