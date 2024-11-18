package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;

public class SimpleMathOperations extends Assignment {

  public SimpleMathOperations(){
    this.name = "Simple Math Operations";
  }

  @Override
  public void run (){
    //print intro message
    System.out.println("Welcome to the Simple Math Operation Program 3000000 (because 3000 wasn't enough)!\nSimply input two numbers and this program will tell you their\nsum, difference, product, and quotient. The first number will always be first in the\nequations, this may give different results for the difference and quotient based on\nthe order you input the numbers in.");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //get numbers
      double a = TextInput.doubleInput("Input the first number: ", null);
      double b = TextInput.doubleInput("Input the second number: ", null);

      //perform calculations
      double sum = a + b;
      double difference = a - b;
      double product = a * b;
      double quotient = a / b;

      //output results
      System.out.println("The results for numbers " + a + " and " + b + ":\nSum: " + sum + "\nDifference: " + difference + "\nProduct: " + product + "\nQuotient: " + quotient);

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Would you like to check another pair of numbers?", null);
    }

    System.out.println("Goodbye!");
  }
}
