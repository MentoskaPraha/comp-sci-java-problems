package com.mentoskapraha.comp_sci.common;

import java.util.Scanner;

public class TextInput {
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Gives the user a yes or no prompt in the terminal.
   * @param defaultAnswerIsYes If true the default answer will be yes, if false then it's no. The default answer is the answer that gets selected if the user just presses enter without inputting anything.
   * @param question The prompt that the user will answer yes or no. (optional)
   * @param invalidInputMessage The message that gets displayed if the input is invalid. (optional)
   * @return True if the answer was yes, false if it was no.
   */
  public static boolean yesNoInput(boolean defaultAnswerIsYes, String question, String invalidInputMessage){
    //setup variable
    question = question != null ? question : "Are you sure?";
    invalidInputMessage = invalidInputMessage != null ? invalidInputMessage : "Invalid input, please try again.";

    boolean result = false;
    boolean validInput = false;
    while (!validInput) {
      System.out.print(question + " [" + (defaultAnswerIsYes ? "Y/n" : "y/N") + "] ");

      String input = scanner.nextLine().strip().toLowerCase();
      Character answer = input.isEmpty() ? '0' : input.charAt(0);

      if (answer.equals('y') || (defaultAnswerIsYes && answer.equals('0'))) {
        validInput = true;
        result = true;
      } else if (answer.equals('n') || (!defaultAnswerIsYes && answer.equals('0'))) {
        validInput = true;
      } else {
        System.out.println(invalidInputMessage);
      }
    }

    return result;
  }

  /**
   * Allows the user to input only numbers in the terminal.
   * @param prompt The prompt presented to the user with instructions to input a number. (optional)
   * @param invalidInputPrompt The prompt presented when the user inputs an invalid input. (optional)
   * @return The number as a string
   */
  public static String numberInput(String prompt, String invalidInputPrompt){
    //setup variables
    prompt = prompt != null ? prompt : "Please input a number: ";
    invalidInputPrompt = invalidInputPrompt != null ? invalidInputPrompt : "Invalid Input!\nPlease try again: ";
    String result = "";

    //prompt user
    System.out.print(prompt);

    //get input
    boolean validInput = false;
    while (!validInput) {
      result = scanner.nextLine().trim().strip();
      if (result.matches("[0-9]+")){
        validInput = true;
      } else{
        System.out.print(invalidInputPrompt);
      }
    }

    return result;
  }
}
