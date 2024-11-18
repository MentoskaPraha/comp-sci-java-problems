package com.mentoskapraha.comp_sci.assignments;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.mentoskapraha.comp_sci.common.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleMathOperationsTest {

  @Test
  void predefinedTest() throws Exception {
    // Define inputs
    final String[] inputs = {"5", "3", "n"};

    // Capture output
    String output = tapSystemOutNormalized(() -> {
      SimpleMathOperations program = new SimpleMathOperations();
      withTextFromSystemIn(inputs).execute(program::run);
    });

    // Check that the output is correct
    assertTrue(output.contains("Sum: 8.0"));
    assertTrue(output.contains("Difference: 2.0"));
    assertTrue(output.contains("Product: 15.0"));
    assertTrue(output.contains("Quotient: 1.6666666"));
  }

  @Test
  void divideZero() throws Exception {
    // Define inputs
    final String[] inputs = {"0", "5", "n"};

    // Capture output
    String output = tapSystemOutNormalized(() -> {
      SimpleMathOperations program = new SimpleMathOperations();
      withTextFromSystemIn(inputs).execute(program::run);
    });

    // Check that the output is correct
    assertTrue(output.contains("Sum: 5.0"));
    assertTrue(output.contains("Difference: -5.0"));
    assertTrue(output.contains("Product: 0.0"));
    assertTrue(output.contains("Quotient: 0.0"));
  }

  @Test
  void divideByZero() throws Exception {
    // Define inputs
    final String[] inputs = {"5", "0", "n"};

    // Capture output
    String output = tapSystemOutNormalized(() -> {
      SimpleMathOperations program = new SimpleMathOperations();
      withTextFromSystemIn(inputs).execute(program::run);
    });

    // Check that the output is correct
    assertTrue(output.contains("Sum: 5.0"));
    assertTrue(output.contains("Difference: 5.0"));
    assertTrue(output.contains("Product: 0.0"));
    assertTrue(output.contains("Quotient: Infinity"));
  }

  @Test
  void randomisedRepeatedTest() throws Exception {
    //generate dummy data
    List<Map<String, Double>> data = new ArrayList<>();
    for(int i = 0; i < 100; i++) {
      //generate numbers
      double firstNum = Utils.getRandomNumber(0, 999);
      double secondNum = Utils.getRandomNumber(0, 999);

      //map numbers and answers to list
      Map<String, Double> run = new HashMap<>();
      run.put("firstNum", firstNum);
      run.put("secondNum", secondNum);
      run.put("expectedSum", firstNum + secondNum);
      run.put("expectedDifference", firstNum - secondNum);
      run.put("expectedProduct", firstNum * secondNum);
      run.put("expectedQuotient", firstNum / secondNum);

      //add that data to the list
      data.add(run);
    }

    //map the data so they can be inputted
    String[] inputs = new String[data.size() * 3];
    int j = 2;
    for(int i = 0; i < data.size(); i++){
      Map<String, Double> run = data.get(i);
      inputs[j-2] = Double.toString(run.get("firstNum"));
      inputs[j-1] = Double.toString(run.get("secondNum"));
      inputs[j] = i != (data.size() - 1) ? "y" : "n";
      j += 3;
    }

    //run the program
    String output = tapSystemOutNormalized(() -> {
      SimpleMathOperations program = new SimpleMathOperations();
      withTextFromSystemIn(inputs).execute(program::run);
    });

    //validate all the equations
    for (Map<String, Double> run : data) {
      assertTrue(output.contains("Sum: " + run.get("expectedSum")));
      assertTrue(output.contains("Difference: " + run.get("expectedDifference")));
      assertTrue(output.contains("Product: " + run.get("expectedProduct")));
      assertTrue(output.contains("Quotient: " + run.get("expectedQuotient")));
    }
  }
}
