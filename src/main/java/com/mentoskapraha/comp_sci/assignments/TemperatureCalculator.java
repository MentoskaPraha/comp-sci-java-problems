package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;

public class TemperatureCalculator extends Assignment {

  public TemperatureCalculator(){
    this.name = "Temperature Calculator";
  }

  @Override
  public void run (){
    //print intro message
    System.out.println("Welcome to the Temperature Calculator Program 3000000 (because 3000 wasn't enough)!\nSimply input the Celsius temperature you wish to convert to Fahrenheit and it will be done.");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //get temperature
      double temp = TextInput.doubleInput("Please input your Celsius temperature: ", "That is not a valid Celsius temperature!\nPlease try again: ");

      //output converted temperature
      System.out.println("Your Celsius temperature in Fahrenheit is " + ((temp * 9/5) + 32) + "°.");

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Do you wish to convert another Celsius temperature to Fahrenheit?", null);
    }

    System.out.println("Goodbye!");
  }
}
