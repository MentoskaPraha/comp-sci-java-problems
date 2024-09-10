package com.mentoskapraha.comp_sci;

import java.util.Scanner;

public class NumberReversal {
  private final static Scanner input = new Scanner(System.in);

  public static void main(String[] args){
    //Print intro message
    System.out.println("Welcome to the Number Reversal Program 3000000 (because 3000 wasn't enough)!\nAny number that you input into this program will be reversed (so 1234 becomes 4321).\nThe program will also tell you if the number you inputted is the same as the reversed version, also know as a palindrome.");

    //Run main program loop
    boolean exit = false;
    while (!exit){
      String number = "";

      //Number input
      System.out.print("Please input a number: ");
      boolean validInput = false;
      while (!validInput) {
        number = input.nextLine().trim().strip();
        if (number.matches("[0-9]+")){
          validInput = true;
        } else{
          System.out.print("Invalid Input!\nPlease try again: ");
        }
      }

      //Reverse number
      StringBuilder reverseNumberBuilder = new StringBuilder();
      for (int i = number.length() - 1; i >= 0; i--){
        reverseNumberBuilder.append(number.charAt(i));
      }
      String reverseNumber = reverseNumberBuilder.toString();

      //determine if it is a palindrome
      boolean isPalindrome = number.matches(reverseNumber);

      //print result
      System.out.println("Your reversed number (which is " + (isPalindrome ? "" : "not ") + "a palindrome): " + reverseNumber);

      //Exit confirmation
      boolean validExitInput = false;
      while (!validExitInput) {
        System.out.print("Would you like to input another number? [y/N] ");
        String answer = input.nextLine().trim().strip().toLowerCase();
        if (answer.equals("y")) {
          validExitInput = true;
        } else if (answer.equals("n") || answer.isEmpty()) {
          validExitInput = true;
          exit = true;
        } else {
          System.out.println("Invalid input, please try again.");
        }
      }
    }

    System.out.println("Goodbye!\nProgram exited with Exit Code 0");
  }
}
