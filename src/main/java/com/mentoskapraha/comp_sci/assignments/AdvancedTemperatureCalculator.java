package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;
import com.mentoskapraha.comp_sci.common.TextMenu;

public class AdvancedTemperatureCalculator extends Assignment {

  public AdvancedTemperatureCalculator(){
    this.name = "Advanced Temperature Calculator";
  }

  @Override
  public void run (){
    //print intro message
    System.out.println("Welcome to the Advance Temperature Calculator Program 3000000 (because 3000 wasn't enough)!\nSelect from what temperature system you want to convert from and then convert to.\nAfter that input your temperature and it will be converted.");

    //define menu
    TextMenu menu = new TextMenu(
            "Please select a temperature conversion.",
            "Make a selection: ",
            "That is not a valid option! Try again: ",
            "Exit",
            "Celsius => Fahrenheit",
            "Celsius => Kelvin",
            "Fahrenheit => Celsius",
            "Fahrenheit => Kelvin",
            "Kelvin => Celsius",
            "Kelvin => Fahrenheit"
    );

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //prompt the user
      int selection = menu.display();

      //run the correct program
      switch (selection){
        case 1: {
          CtoF();
          break;
        }
        case 2: {
          CtoK();
          break;
        }
        case 3: {
          FtoC();
          break;
        }
        case 4: {
          FtoK();
          break;
        }
        case 5: {
          KtoC();
          break;
        }
        case 6: {
          KtoF();
          break;
        }
        default: {
          exit = true;
          break;
        }
      }
    }

    System.out.println("Goodbye!");
  }

  private static void CtoF(){
    //get temperature
    double temp = TextInput.doubleInput("Please input your Celsius temperature: ", "That is not a valid Celsius temperature!\nPlease try again: ");

    //output converted temperature
    System.out.println("Your Celsius temperature in Fahrenheit is " + ((temp * 9/5) + 32) + "°.");
  }

  private static void CtoK(){
    //get temperature
    double temp = TextInput.doubleInput("Please input your Celsius temperature: ", "That is not a valid Celsius temperature!\nPlease try again: ");

    //output converted temperature
    System.out.println("Your Celsius temperature in Kelvin is " + (temp + 273.15) + "°.");
  }

  private static void FtoC(){
    //get temperature
    double temp = TextInput.doubleInput("Please input your Fahrenheit temperature: ", "That is not a valid Fahrenheit temperature!\nPlease try again: ");

    //output converted temperature
    System.out.println("Your Fahrenheit temperature in Celsius is " + (((temp - 32) * 5) / 9) + "°.");
  }

  private static void FtoK(){
    //get temperature
    double temp = TextInput.doubleInput("Please input your Fahrenheit temperature: ", "That is not a valid Fahrenheit temperature!\nPlease try again: ");

    //output converted temperature
    System.out.println("Your Fahrenheit temperature in Kelvin is " + ((((temp - 32) * 5) / 9) + 273.15) + "°.");
  }

  private static void KtoC(){
    //get temperature
    double temp = TextInput.doubleInput("Please input your Kelvin temperature: ", "That is not a valid Kelvin temperature!\nPlease try again: ");

    //output converted temperature
    System.out.println("Your Kelvin temperature in Celsius is " + (temp - 273.15) + "°.");
  }

  private static void KtoF(){
    //get temperature
    double temp = TextInput.doubleInput("Please input your Kelvin temperature: ", "That is not a valid Kelvin temperature!\nPlease try again: ");

    //output converted temperature
    System.out.println("Your Kelvin temperature in Fahrenheit is " + (((temp - 273.15) * 1.8) + 32) + "°.");
  }
}
