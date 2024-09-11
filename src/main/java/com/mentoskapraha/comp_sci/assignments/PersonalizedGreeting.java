package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.TextInput;

public class PersonalizedGreeting {
  public static void main (String[] args){
    String name = TextInput.stringInput("What is your name? ", "Your name can't possibly be blank? So, what is it? ");
    System.out.println("Good day to you Sir " + name + "!");
  }
}
