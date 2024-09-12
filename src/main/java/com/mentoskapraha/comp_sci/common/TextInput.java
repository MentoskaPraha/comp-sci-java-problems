package com.mentoskapraha.comp_sci.common;

import java.util.Scanner;

/**
 * This class has useful methods for getting user input.
 * All methods on it are static so it doesn't need to be
 * instantiated every time you want to use it, simply call
 * the method you wish to use.
 * @author MentoskaPraha
 */
public class TextInput {
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Gives the user a yes or no prompt in the terminal.
   * @param defaultAnswerIsYes If true the default answer will be yes, if false then it's no. The default answer is the answer that gets selected if the user just presses enter without inputting anything.
   * @param question The prompt that the user will answer yes or no. (optional)
   * @param invalidInputMessage The message that gets displayed if the input is invalid. (optional)
   * @return True if the answer was yes, false if it was no.
   * @author MentoskaPraha
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
   * @return The number that was inputted.
   * @author MentoskaPraha
   */
  public static int integerInput(String prompt, String invalidInputPrompt){
    //setup variables
    prompt = prompt != null ? prompt : "Please input a number: ";
    invalidInputPrompt = invalidInputPrompt != null ? invalidInputPrompt : "Invalid Input :)\nPlease try again: ";
    int result = 0;

    //prompt user
    System.out.print(prompt);

    //get input
    boolean validInput = false;
    while (!validInput) {
      String input = scanner.nextLine().trim().strip();
      if (input.isBlank() || input.isEmpty()){
        System.out.print(invalidInputPrompt);
      } else{
        try {
          result = Integer.parseInt(input);
          validInput = true;
        } catch (Exception e){
          System.out.print(invalidInputPrompt);
        }
      }
    }

    return result;
  }

  /**
   * The function allows the user to input a string, the program ensures it's not empty or blank.
   * @param prompt The prompt presented to the user with instructions to input a number. (optional)
   * @param invalidInputPrompt The prompt presented when the user inputs an invalid input(ei the string is blank or empty). (optional)
   * @return The inputted String
   * @author MentoskaPraha
   */
  public static String stringInput(String prompt, String invalidInputPrompt){
    //setup variables
    prompt = prompt != null ? prompt : "Please input a string: ";
    invalidInputPrompt = invalidInputPrompt != null ? invalidInputPrompt : "Invalid Input, input cannot be empty!\nPlease try again: ";
    String result = "";

    //prompt user
    System.out.print(prompt);

    //get input
    boolean validInput = false;
    while (!validInput) {
      result = scanner.nextLine().trim().strip();
      if (result.isBlank() || result.isEmpty()){
        System.out.print(invalidInputPrompt);
      } else{
        validInput = true;
      }
    }

    return result;
  }

  /**
   * Allows the user to input a float
   * @param prompt The prompt presented to the user with instructions to input a float number. (optional)
   * @param invalidInputPrompt The prompt presented when the user inputs an invalid input. (optional)
   * @return The float that was inputted.
   * @author MentoskaPraha
   */
  public static float floatInput(String prompt, String invalidInputPrompt){
    //setup variables
    prompt = prompt != null ? prompt : "Please input a float: ";
    invalidInputPrompt = invalidInputPrompt != null ? invalidInputPrompt : "Invalid Input :)\nPlease try again: ";
    float result = 0;

    //prompt user
    System.out.print(prompt);

    //get input
    boolean validInput = false;
    while (!validInput) {
      String input = scanner.nextLine().trim().strip();
      if (input.isBlank() || input.isEmpty()){
        System.out.print(invalidInputPrompt);
      } else{
        try {
          result = Float.parseFloat(input);
          validInput = true;
        } catch (Exception e){
          System.out.print(invalidInputPrompt);
        }
      }
    }

    return result;
  }

  /**
   * Get several number inputs from the user.
   * @param numOfInputs How many numbers the user will input.
   * @param prompt The prompt presented to the user to give them context as to why they're inputting all the numbers. (optional)
   * @param invalidInputPrompt The prompt presented when the user inputs an invalid input. (optional)
   * @return An array of all the inputs, the numbers are strings and will need to be converted.
   * @author MentoskaPraha
   */
  public static float[] multiFloatInput(int numOfInputs, String prompt, String invalidInputPrompt) {
    //setup variables
    prompt = prompt != null ? prompt : "You will be inputting several(" + numOfInputs + ") numbers.";
    invalidInputPrompt = invalidInputPrompt != null ? invalidInputPrompt : "Invalid Input :)\nPlease try again: ";
    float[] result = new float[numOfInputs];

    //prompt user
    System.out.println(prompt);

    //get inputs
    for(int i = 0; i < result.length; i++){
      result[i] = floatInput((i + 1) + ": ", invalidInputPrompt);
    }

    //return inputs
    System.out.println("Input Complete!");
    return result;
  }
}
