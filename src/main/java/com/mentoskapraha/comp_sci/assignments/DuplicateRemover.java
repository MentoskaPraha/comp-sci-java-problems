package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;

import java.util.LinkedHashSet;

public class DuplicateRemover extends Assignment {

  public DuplicateRemover(){
    this.name = "Duplicate Remover";
  }

  @Override
  public void run(){
    //print intro message
    System.out.println("Welcome to the Duplicate Remover Program 3000000 (because 3000 wasn't enough)!\nSimply input an array of numbers and the program will remove all elements that occur more than once.");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //ask the user for length of array
      int length = TextInput.integerInput("How long do you want your array to be: ", null);

      //ask the user for array data
      int[] array = TextInput.multiIntegerInput(length, "Please input the numbers of the array.", null);

      /*
        Remove the duplicates by mapping them from an
        array to a LinkedHashSet. This works because sets
        don't allow duplicate elements and attempting to
        add a duplicate element to a set will result in
        that element being voided. The LinkedHashSet is used
        because it keeps the order of the elements.
       */
      LinkedHashSet<Integer> result
              = new LinkedHashSet<>();
      for (int num : array) result.add(num);

      //create the result String and print it
      StringBuilder resultOutput = new StringBuilder();
      resultOutput.append("Your array with all duplicates removed:\n");
      for(int num : result) resultOutput.append(num).append("  ");
      System.out.println(resultOutput);

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Would you like to check another array?", null);
    }

    System.out.println("Goodbye!");
  }
}
