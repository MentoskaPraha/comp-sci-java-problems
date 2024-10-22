package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;

public class AssignmentTemplate extends Assignment {
  public AssignmentTemplate(){
    this.name = "REPLACE ME WITH THE NAME OF THE ASSIGNMENT!";
  }

  @Override
  public void run(){
    //print intro message
    System.out.println("Welcome to the [TITLE HERE] Program 3000000 (because 3000 wasn't enough)!\n[INSTRUCTIONS HERE]");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //Ask if the user wants to exit or not
      exit = TextInput.yesNoInput(true, "Do you wish to exit?", null);
    }

    System.out.println("Goodbye!");
  }
}
