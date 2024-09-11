package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.TextInput;

public class SimpleMathOperations {
  public static void main (String[] args){
    //print intro message
    System.out.println("Welcome to the Simple Math Operation Program 3000000 (because 3000 wasn't enough)!\nSimply input two positive integers and this program will tell you their\nsum, difference, product, and quotient. The first number will always be first in the\nequations, this may give different results for the difference and quotient based on\nthe order you input the numbers in.");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //get numbers
      float a = Float.parseFloat(TextInput.integerInput("Input the first positive integer: ", null));
      float b = Float.parseFloat(TextInput.integerInput("Input the second positive integer: ", null));

      //perform calculations
      float sum = a + b;
      float difference = a - b;
      float product = a * b;
      float quotient = a / b;

      //output results
      System.out.println("The results for numbers " + a + " and " + b + ":\nSum: " + sum + "\nDifference: " + difference + "\nProduct: " + product + "\nQuotient: " + quotient);

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Would you like to check another pair of positive integers?", null);
    }

    System.out.println("Goodbye!\nProgram exited with Exit Code 0");
  }
}