package com.mentoskapraha.comp_sci.common;

import java.util.Arrays;

/**
 * Displays a text menu with multiple option for the user to
 * select from.
 * @author MentoskaPraha
 */
public class TextMenu {
  private String[] menuOptions;
  private String menuTitle;
  private String menuInputPrompt;
  private String menuInvalidInput;
  private String menuCancelOptionText;

  /**
   * Create a new text menu, which can allow the user to select from multiple
   * options.
   * @param title The title of the menu.
   * @param inputPrompt The prompt that prompts the user for input.
   * @param invalidInput The text to be displayed if the input is invalid.
   * @param cancelOptionText The text that is displayed for option 0, aka cancel.
   * @param options All the options the user can select from, must have at least 3.
   */
  public TextMenu(String title, String inputPrompt, String invalidInput, String cancelOptionText, String... options){
    if (options.length < 3) throw new IllegalArgumentException("There must be at least 3 options.");
    this.menuOptions = options;
    this.menuTitle = title;
    this.menuInputPrompt = inputPrompt;
    this.menuInvalidInput = invalidInput;
    this.menuCancelOptionText = cancelOptionText;
  }

  /**
   * Overwrite the existing options.
   * @param newOptions The new options, must have at least 3.
   */
  public void setOptions(String... newOptions){
    if (newOptions.length < 3) throw new IllegalArgumentException("There must be at least 3 options.");
    this.menuOptions = newOptions;
  }

  /**
   * Update the title.
   * @param newTitle The new title.
   */
  public void setTitle(String newTitle){
    this.menuTitle = newTitle;
  }

  /**
   * Update the input prompt.
   * @param newInputPrompt The new input prompt.
   */
  public void setInputPrompt(String newInputPrompt){
    this.menuInputPrompt = newInputPrompt;
  }

  /**
   * Update the invalid input message.
   * @param newInvalidInput The new invalid input message.
   */
  public void setInvalidInput(String newInvalidInput){
    this.menuInvalidInput = newInvalidInput;
  }

  /**
   * Update the cancel option text.
   * @param newCancelOptionText The new cancel input text message.
   */
  public void setCancelOptionText(String newCancelOptionText){
    this.menuCancelOptionText = newCancelOptionText;
  }

  /**
   * Add an extra option.
   * @param option The new option.
   */
  public void addOption(String option){
    String[] newOptions = Arrays.copyOf(this.menuOptions, this.menuOptions.length + 1);
    newOptions[newOptions.length - 1] = option;
    this.menuOptions = newOptions;
  }

  /**
   * Displays the menu.
   * @return The option that was selected, 0 meaning the user aborted.
   */
  public int display(){
    //print out the title
    System.out.println(this.menuTitle);

    //print out the options
    for(int i = 0; i < menuOptions.length; i++){
      System.out.println("\t[" + (i + 1) + "] " + menuOptions[i]);
    }
    System.out.println("\t[0] " + menuCancelOptionText);

    //have the user make a selection
    int result = 0;
    boolean validInput = false;
    while (!validInput) {
      int input = TextInput.integerInput(
              menuInputPrompt + "[0-" + menuOptions.length + "]: ",
              menuInvalidInput
      );
      if (input >= 0 && input <= menuOptions.length){
        validInput = true;
        result = input;
      } else{
        System.out.println("Please ensure the inputted number is between 0 and " + menuOptions.length + ".");
      }
    }

    return result;
  }
}
