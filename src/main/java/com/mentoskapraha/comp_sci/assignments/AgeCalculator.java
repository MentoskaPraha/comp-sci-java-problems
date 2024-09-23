package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;
import java.time.LocalDate;

public class AgeCalculator extends Assignment {

  public AgeCalculator(){
    this.name = "Age Calculator";
  }

  @Override
  public void run (){
    //print intro message
    System.out.println("Welcome to the Age Calculator Program 3000000 (because 3000 wasn't enough)!\nSimply input the year you were born in and this program will tell you how old you are.");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //get birth year
      int birthYear = TextInput.integerInput("Please input your birth year: ", "That is not a valid birth year!\nPlease try again: ");

      //output how old the user is
      System.out.println("You are " + (LocalDate.now().getYear() - birthYear) + " years old!");

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Do you wish to calculated another age?", null);
    }

    System.out.println("Goodbye!");
  }
}
