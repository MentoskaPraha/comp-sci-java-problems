package com.mentoskapraha.comp_sci.assignments;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SimpleGreetingTest {

  @Test
  void test() throws Exception {
    //run program
    SimpleGreeting program = new SimpleGreeting();
    String output = tapSystemOutNormalized(program::run);

    //ensure it outputs Hello World
    assertTrue(output.contains("Hello World!"));
  }
}
