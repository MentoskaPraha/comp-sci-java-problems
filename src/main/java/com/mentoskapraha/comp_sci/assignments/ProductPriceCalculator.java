package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;
import com.mentoskapraha.comp_sci.common.TextInput;

public class ProductPriceCalculator extends Assignment {

  public ProductPriceCalculator(){
    this.name = "Product Price Calculator";
  }

  @Override
  public void run (){
    //print intro message
    System.out.println("Welcome to the Product Price Calculator Program 3000000 (because 3000 wasn't enough)!\nFirst tell us how many products you have, then input their price, after which this\nprogram will tell you the total and average price.");

    //run main program loop
    boolean exit = false;
    while (!exit) {
      //get data
      int numProducts = TextInput.integerInput("Please input the number of products you have: ", null);
      float[] prices = TextInput.multiFloatInput(numProducts, "You're inputting the prices of " + numProducts + ".", null);

      //get total;
      float total = 0;
      for (float price : prices) {
        total = total + price;
      }

      //get average
      float average = total / prices.length;

      //display this information
      System.out.println("Total Price: " + total + "\nAverage Price: " + average);

      //Ask if the user wants to exit or not
      exit = !TextInput.yesNoInput(false, "Would you like to check another list of products?", null);
    }

    System.out.println("Goodbye!");
  }
}
