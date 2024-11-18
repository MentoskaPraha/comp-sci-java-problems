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

    //instance scanner
    final Scanner scanner = new Scanner(System.in);

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

    //close scanner and return results
    scanner.close();
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

    //instance scanner
    final Scanner scanner = new Scanner(System.in);

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

    //close scanner and return
    scanner.close();
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

    //instance scanner
    final Scanner scanner = new Scanner(System.in);

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

    //close scanner and return result
    scanner.close();
    return result;
  }

  /**
   * Allows the user to input a double
   * @param prompt The prompt presented to the user with instructions to input a float number. (optional)
   * @param invalidInputPrompt The prompt presented when the user inputs an invalid input. (optional)
   * @return The double that was inputted.
   * @author MentoskaPraha
   */
  public static double doubleInput(String prompt, String invalidInputPrompt){
    //setup variables
    prompt = prompt != null ? prompt : "Please input a double: ";
    invalidInputPrompt = invalidInputPrompt != null ? invalidInputPrompt : "Invalid Input :)\nPlease try again: ";
    double result = 0;

    //instance scanner
    final Scanner scanner = new Scanner(System.in);

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
          result = Double.parseDouble(input);
          validInput = true;
        } catch (Exception e){
          System.out.print(invalidInputPrompt);
        }
      }
    }

    //close scanner and return result
    scanner.close();
    return result;
  }

  /**
   * Get several number inputs from the user.
   * @param numOfInputs How many numbers the user will input.
   * @param prompt The prompt presented to the user to give them context as to why they're inputting all the numbers. (optional)
   * @param invalidInputPrompt The prompt presented when the user inputs an invalid input. (optional)
   * @return An array of all the inputs.
   * @author MentoskaPraha
   */
  public static double[] multiDoubleInput(int numOfInputs, String prompt, String invalidInputPrompt) {
    //setup variables
    prompt = prompt != null ? prompt : "You will be inputting several(" + numOfInputs + ") numbers.";
    invalidInputPrompt = invalidInputPrompt != null ? invalidInputPrompt : "Invalid Input :)\nPlease try again: ";
    double[] result = new double[numOfInputs];

    //instance scanner
    final Scanner scanner = new Scanner(System.in);

    //prompt user
    System.out.println(prompt);

    //get inputs
    for(int i = 0; i < result.length; i++){
      result[i] = doubleInput((i + 1) + ": ", invalidInputPrompt);
    }

    //return inputs
    System.out.println("Input Complete!");
    scanner.close();
    return result;
  }

  /**
   * Get several number inputs from the user.
   * @param numOfInputs How many numbers the user will input.
   * @param prompt The prompt presented to the user to give them context as to why they're inputting all the numbers. (optional)
   * @param invalidInputPrompt The prompt presented when the user inputs an invalid input. (optional)
   * @return An array of all the inputs.
   * @author MentoskaPraha
   */
  public static int[] multiIntegerInput(int numOfInputs, String prompt, String invalidInputPrompt) {
    //setup variables
    prompt = prompt != null ? prompt : "You will be inputting several(" + numOfInputs + ") numbers.";
    invalidInputPrompt = invalidInputPrompt != null ? invalidInputPrompt : "Invalid Input :)\nPlease try again: ";
    int[] result = new int[numOfInputs];

    //instance scanner
    final Scanner scanner = new Scanner(System.in);

    //prompt user
    System.out.println(prompt);

    //get inputs
    for(int i = 0; i < result.length; i++){
      result[i] = integerInput((i + 1) + ": ", invalidInputPrompt);
    }

    //return inputs
    System.out.println("Input Complete!");
    scanner.close();
    return result;
  }

  /**
   * Will prompt the user to input a password. The password
   * must contain at least one special character, at least one
   * number, at least one capital character and must be at least
   * 12 characters long.
   * @param prompt A prompt that gets printed before the password input occurs, can be blank, but not null.
   * @return The inputted password
   * @author MentoskaPraha
   */
  public static String newPasswordInput(String prompt){
    //setup vars
    String result = "";

    //instance scanner
    final Scanner scanner = new Scanner(System.in);

    //prompt user
    System.out.println(prompt);

    boolean validInput = false;
    String passwordPrompt = "Please enter your new password: ";
    while(!validInput){
      //prompt user for password
      String firstInput = TextInput.stringInput(passwordPrompt, "Password cannot be blank or empty, please try again: ");

      //check password
      if(firstInput.length() < 12){
        passwordPrompt = "The password must be at least 12 characters!\nPlease try again: ";
        continue;
      }

      if(!firstInput.matches(".*[A-Z].*")){
        passwordPrompt = "At least 1 capital letter is required!\nPlease try again: ";
        continue;
      }

      if(!firstInput.matches(".*[a-z].*")){
        passwordPrompt = "At least 1 non-capital letter is required!\nPlease try again: ";
        continue;
      }

      if(!firstInput.matches(".*\\d.*")){
        passwordPrompt = "At least 1 number is required!\nPlease try again: ";
        continue;
      }

      if(!firstInput.matches(".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*")){
        passwordPrompt = "At least 1 special character is required!\nPlease try again: ";
        continue;
      }

      //get the user to retype the password
      passwordPrompt = "Please re-enter your new password: ";
      String secondInput = TextInput.stringInput(passwordPrompt, "Password cannot be blank or empty, please try again: ");

      if(secondInput.matches(firstInput)){
        validInput = true;
        result = secondInput;
      } else {
        passwordPrompt = "Passwords don't match!\nPlease try again: ";
      }
    }

    //close scanner and return result
    scanner.close();
    return result;
  }

  /**
   * Waits for the user to press enter before continuing.
   * @param notification Some text to display context to the user, there is a default if String is null.
   * @author MentoskaPraha
   */
  public static void pressEnterToContinue(String notification) {
    //setup
    notification = notification != null ? notification : "Press enter to continue...";
    System.out.print(notification);

    //instance scanner
    final Scanner scanner = new Scanner(System.in);

    //wait for input
    scanner.nextLine();

    //close scanner
    scanner.close();
  }
}
