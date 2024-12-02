package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;

public class ScrabbleScorer extends Assignment {
  public ScrabbleScorer(){
    this.name = "Scrabble Scorer";
  }

  @Override
  public void run (){
    //Print intro message
    System.out.println("Welcome to the Scrabble Scorer 3000000 (because 3000 wasn't enough)!\nThis program will take a letter and give you it's score in the hit game Scrabble.");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //Get the character to score
      String input = TextInput.stringInput("Please input the letter you wish to check: ", "That is not a letter lol\nTry again: ");
      char letter = input.toLowerCase().charAt(0);

      //get the score
      int score = scoreLetter(letter);

      //output the result
      System.out.println("The score for the letter [" + letter + "] is " + score + ".");

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Do you wish to check another letter?", null);
    }

    System.out.println("Goodbye!");
  }

  private static int scoreLetter(char letter){
    switch (letter){
      case 'e', 'a', 'i', 'o', 'n', 'r', 't', 'l', 's', 'u' -> {
        return 1;
      }
      case 'd', 'g' -> {
        return 2;
      }
      case 'b', 'c', 'm', 'p' -> {
        return 3;
      }
      case 'f', 'h', 'v', 'w', 'y' -> {
        return 4;
      }
      case 'k' -> {
        return 5;
      }
      case 'j', 'x' -> {
        return 8;
      }
      case 'q', 'z' -> {
        return 10;
      }
      default -> {
        return 0;
      }
    }
  }
}
