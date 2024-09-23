package com.mentoskapraha.comp_sci.common;

/**
 * Creates an assignment with certain predefined data.
 * This class is meant to be extended in each class in
 * the assignments package, so that they can then be
 * added into a list in the Main class so that they can
 * be run. Each assignment should override the run method
 * and set its name in the constructor.
 * @author MentoskaPraha
 */
public class Assignment {
  /**
   * The name of the assignment.
   */
  public String name = "Epic Assignment";

  /**
   * The main method of the assignment.
   * Must be overridden!
   */
  public void run() {
    throw new RuntimeException("This function has yet to be implemented!");
  }
}
