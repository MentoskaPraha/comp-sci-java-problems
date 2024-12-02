package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;

public class VotingEligibilityChecker extends Assignment {

  public VotingEligibilityChecker(){
    this.name = "Voting Eligibility Checker";
  }

  @Override
  public void run (){
    //Print intro message
    System.out.println("Welcome to the Voting Eligibility Checker 3000000 (because 3000 wasn't enough)!\nThis program checks if you are eligible to vote in a country.\nFirst input the country and the minimum voting age, then answer\nthe questions about yourself and the program will tell you if\nyou can vote or not.");

    //main program loop
    boolean exit = false;
    while (!exit){
      //get user input
      String country = TextInput.stringInput("Input the name of the country: ", null);
      int minAge = TextInput.integerInput("Input the minimum voting age: ", null);
      boolean citizenship = TextInput.yesNoInput(true,"Are you a citizen of " + country + "?", null);
      int age = TextInput.integerInput("Input your age: ", null);

      //check eligibility
      boolean eligible = citizenship;
      boolean ageFailed = false;

      if(age < minAge){
        eligible = false;
        ageFailed = true;
      }

      //print result
      if(eligible){
        System.out.println("You are eligible to vote in " + country + ".");
      } else {
        System.out.println("You are not eligible to vote in " + country + ", because" + (!citizenship ? " you need citizenship in the country you're voting in" : "") + ((!citizenship && ageFailed) ? " and" : "") + (ageFailed ? " you are not of voting age" : "") + ".");
      }

      //ask if you want to exit or not
      exit = !TextInput.yesNoInput(false, "Do you want to check another country or person?", null);
    }

    System.out.println("Goodbye!");
  }
}
