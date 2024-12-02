package com.mentoskapraha.comp_sci;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;
import com.mentoskapraha.comp_sci.common.TextMenu;
import com.mentoskapraha.comp_sci.assignments.*;

import java.util.Arrays;

public class Main {
  private static final Assignment[] assignments = {
          new SimpleGreeting(),
          new PersonalizedGreeting(),
          new AgeCalculator(),
          new TemperatureCalculator(),
          new SimpleMathOperations(),
          new EvenAndOddCounter(),
          new ProductPriceCalculator(),
          new VotingEligibilityChecker(),
          new NumberReversal(),
          new SimpleLoginSystem(),
          new MaxValueFinder(),
          new ListCounter(),
          new DuplicateRemover(),
          new AdvancedTemperatureCalculator(),
          new FibonacciGenerator(),
          new BasicBankingSystem(),
          new PrimeNumberFinder(),
          new NumberCompareFunction(),
          new MacdonaldFarm(),
          new ScrabbleScorer()
  };

  public static void main(String[] args) {
    //create the text menu
    TextMenu menu = new TextMenu(
            "Welcome to the Assignment Runner!\nSimply select the assignment you wish to run and it will do so.",
            "Please make a selection:",
            "Invalid Input :)\nPlease try again: ",
            "Exit",
            Arrays.stream(assignments).map(assignment -> assignment.name).toArray(String[]::new)
    );

    //main program loop
    boolean exit = false;
    while(!exit) {
      //have to user chose an assignment
      int choice = menu.display();

      //exit or run the assignment
      if(choice == 0){
        exit = true;
      } else {
        assignments[choice - 1].run();
        TextInput.pressEnterToContinue(null);
      }
    }

    System.out.println("\nGoodbye!\nProgram exited with Exit Code 0");
  }
}
