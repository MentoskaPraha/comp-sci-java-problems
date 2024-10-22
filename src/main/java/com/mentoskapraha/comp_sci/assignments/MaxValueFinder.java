package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;

public class MaxValueFinder extends Assignment {

  public MaxValueFinder(){
    this.name = "Max Value Counter";
  }

  @Override
  public void run(){
    //print intro message
    System.out.println("Welcome to the Max Value Finder Program 3000000 (because 3000 wasn't enough)!\nSimply input an array of numbers and the program will tell you the largest number.");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //ask the user for length of array
      int length = TextInput.integerInput("How long do you want your array to be: ", null);

      //ask the user for array data
      int[] array = TextInput.multiIntegerInput(length, "Please input the numbers of the array.", null);

      //compute the largest value in array
      int largest = array[0];
      for(int num : array){
        if(num > largest) largest = num;
      }

      //tell user what largest value in array is
      System.out.println("The largest number inside that array is: " + largest);

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Do you wish to check another set of numbers?", null);
    }

    System.out.println("Goodbye!");
  }
}
