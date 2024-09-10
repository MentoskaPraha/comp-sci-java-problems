package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.TextInput;

public class NumberReversal {

  public static void main(String[] args){
    //Print intro message
    System.out.println("Welcome to the Number Reversal Program 3000000 (because 3000 wasn't enough)!\nAny number that you input into this program will be reversed (so 1234 becomes 4321).\nThe program will also tell you if the number you inputted is the same as the reversed version, also know as a palindrome.");

    //Run main program loop
    boolean exit = false;
    while (!exit){
      String number = TextInput.numberInput(null, null);

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

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Would you like to input another number?", null);
    }

    System.out.println("Goodbye!\nProgram exited with Exit Code 0");
  }
}
