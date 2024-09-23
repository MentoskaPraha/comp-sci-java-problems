package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;

public class SimpleGreeting extends Assignment {
  public SimpleGreeting() {
    this.name = "Simple Greeting";
  }

  @Override
  public void run (){
    System.out.println("Hello World!");
  }
}
