package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;

public class ListCounter extends Assignment {

  public ListCounter(){
    this.name = "List Counter";
  }

  @Override
  public void run(){
    //print intro message
    System.out.println("Welcome to the List Counter Program 3000000 (because 3000 wasn't enough)!\nSimply input an array of numbers and a number you would like to count the occurrence of inside that array.\nThe program will tell you how many times that number appeared.");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //ask the user for length of array
      int length = TextInput.integerInput("How long do you want your array to be: ", null);

      //ask the user for array data
      int[] array = TextInput.multiIntegerInput(length, "Please input the numbers of the array.", null);

      //ask the user for the number they want to count
      int checkFor = TextInput.integerInput("What number do you want to count the occurrence of inside the array? ", null);

      //count the amount of times the checkFor number appears inside the array
      int count = 0;
      for (int num : array) {
        if (num == checkFor) count++;
      }

      //tell the user how many times that number appeared
      System.out.println(checkFor + " appeared " + count + " times inside the array you inputted.");

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Would you like to check another array?", null);
    }

    System.out.println("Goodbye!");
  }
}
