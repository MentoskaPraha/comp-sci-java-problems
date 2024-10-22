package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;

import java.util.LinkedHashSet;

public class PrimeNumberFinder extends Assignment {

  public PrimeNumberFinder(){
    this.name = "Prime Number Finder";
  }

  @Override
  public void run(){
    //print intro message
    System.out.println("Welcome to the Prime Number Finder Program 3000000 (because 3000 wasn't enough)!\nSimply input a number and the program will tell you if it's prime or not.\nAlternatively, you can input 2 numbers and the program will list all prime\nnumbers between those two numbers.");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //Ask the user if they want to look for 1 number of multiple
      boolean singleNumber = TextInput.yesNoInput(true, "Do you wish to check only one number?", null);
      if(singleNumber){
        singleNumberFinder();
      } else {
        multiNumberFinder();
      }

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Do you wish to check another set of numbers?", null);
    }

    System.out.println("Goodbye!");
  }

  private static void singleNumberFinder() {
    //get the number the user wants to check for
    int check = TextInput.integerInput("Please input the number you would like to check is prime: ", null);

    //check if it's prime and output the appropriate result
    if(isPrime(check)) {
      System.out.println(check + " is a prime number.");
    } else {
      System.out.println(check + " is not a prime number.");
    }
  }

  private static void multiNumberFinder() {
    //get user input
    boolean success = false;
    int lowerBound = 0;
    int upperBound = 0;
    while(!success){
      //give instructions
      System.out.println("Please input 2 numbers in between which you wish to check for all prime numbers.\nThe first number must be less than the second number.");

      //get numbers
      lowerBound = TextInput.integerInput("Please input the first number: ", null);
      upperBound = TextInput.integerInput("Please input the second number: ", null);

      //ensure lowerBound is less than upperBound
      if(lowerBound < upperBound){
        success = true;
        System.out.println("Calculating...");
      } else {
        System.out.println("Invalid input! First number must be less than second number.");
      }
    }

    //create the results array
    LinkedHashSet<Integer> results = new LinkedHashSet<>();

    /*
      Check every number between upperBound and lowerBound
      and if they're prime add them to the results set.
     */
    for(int i = lowerBound; i <= upperBound; i++){
      if(isPrime(i)) results.add(i);
    }

    //build and return the results in a string
    StringBuilder resultsString = new StringBuilder();
    if(results.isEmpty()){
      resultsString.append("No prime numbers were found.");
    } else{
      resultsString.append("Here are all the prime numbers:\n");
      for(int num : results) resultsString.append(num).append("  ");
    }
    System.out.println(resultsString);
  }

  /**
   * Checks whether a number is prime.
   * @param num The number to check.
   * @return True if it is prime, false otherwise.
   */
  private static boolean isPrime(int num){
    //prime numbers can't be less or equal to 1
    if(num <= 1) return false;

    /*
      Check if any number from 2 to num-1 is divisible by num,
      if yes num is not prime.
    */
    for (int i = 2; i < num; i++){
      if (num % i == 0) return false;
    }

    //if none of the above holds true the number is prime
    return true;
  }
}
