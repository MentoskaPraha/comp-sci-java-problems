package com.mentoskapraha.comp_sci.common;

import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.*;

class TextInputTest {

  @Test
  void yesNoInput() throws Exception {
    withTextFromSystemIn("", "y", "Y", "yes", "yolo", "Yes", "Yeah boi", "", "n", "N", "no", "nowhere", "Nope", "No sir")
            .execute(() -> {
              assertTrue(TextInput.yesNoInput(true, null, null));
              assertTrue(TextInput.yesNoInput(true, null, null));
              assertTrue(TextInput.yesNoInput(true, null, null));
              assertTrue(TextInput.yesNoInput(true, null, null));
              assertTrue(TextInput.yesNoInput(true, null, null));
              assertTrue(TextInput.yesNoInput(true, null, null));
              assertTrue(TextInput.yesNoInput(true, null, null));

              assertFalse(TextInput.yesNoInput(false, null, null));
              assertFalse(TextInput.yesNoInput(false, null, null));
              assertFalse(TextInput.yesNoInput(false, null, null));
              assertFalse(TextInput.yesNoInput(false, null, null));
              assertFalse(TextInput.yesNoInput(false, null, null));
              assertFalse(TextInput.yesNoInput(false, null, null));
              assertFalse(TextInput.yesNoInput(false, null, null));
            });

    String output = tapSystemOutNormalized(() -> withTextFromSystemIn("test", "")
            .execute(() -> assertTrue(TextInput.yesNoInput(true, "question", "invalid"))));
    assertTrue(output.contains("question"));
    assertTrue(output.contains("invalid"));
  }

  @Test
  void integerInput() throws Exception {
    muteSystemOut(() -> withTextFromSystemIn("5364", "2354676", "45", "-675432")
            .execute(() -> {
              assertEquals(
                      5364,
                      TextInput.integerInput(null, null)
              );
              assertEquals(
                      2354676,
                      TextInput.integerInput(null, null)
              );
              assertEquals(
                      45,
                      TextInput.integerInput(null, null)
              );
              assertEquals(
                      -675432,
                      TextInput.integerInput(null, null)
              );
            }));

    String output = tapSystemOutNormalized(() -> withTextFromSystemIn("invalid", "0")
            .execute(() -> assertEquals(0, TextInput.integerInput("question", "invalid"))));
    assertTrue(output.contains("question"));
    assertTrue(output.contains("invalid"));
  }

  @Test
  void stringInput() throws Exception {
    muteSystemOut(() -> withTextFromSystemIn("test1", "Test2", "@Test%", "Ooonga Boonga")
            .execute(() -> {
              assertEquals(
                      "test1",
                      TextInput.stringInput(null, null)
              );
              assertEquals(
                      "Test2",
                      TextInput.stringInput(null, null)
              );
              assertEquals(
                      "@Test%",
                      TextInput.stringInput(null, null)
              );
              assertEquals(
                      "Ooonga Boonga",
                      TextInput.stringInput(null, null)
              );
            }));

    String output = tapSystemOutNormalized(() -> withTextFromSystemIn("     ", "This is now valid.")
            .execute(() -> assertTrue(TextInput.stringInput("question", "invalid").matches("This is now valid."))));
    assertTrue(output.contains("question"));
    assertTrue(output.contains("invalid"));
  }

  @Test
  void doubleInput() throws Exception {
    muteSystemOut(() -> withTextFromSystemIn("53", "235.58", "-45", "-67.54")
            .execute(() -> {
              assertEquals(
                      53,
                      TextInput.doubleInput(null, null)
              );
              assertEquals(
                      235.58,
                      TextInput.doubleInput(null, null)
              );
              assertEquals(
                      -45,
                      TextInput.doubleInput(null, null)
              );
              assertEquals(
                      -67.54,
                      TextInput.doubleInput(null, null)
              );
            }));

    String output = tapSystemOutNormalized(() -> withTextFromSystemIn("invalid", "0")
            .execute(() -> assertEquals(0, TextInput.doubleInput("question", "invalid"))));
    assertTrue(output.contains("question"));
    assertTrue(output.contains("invalid"));
  }

  @Test
  void multiDoubleInput() throws Exception {
    muteSystemOut(() -> withTextFromSystemIn("53", "235.58", "-45", "-67.54", "8.3066")
            .execute(() -> assertArrayEquals(
                    new double[]{53, 235.58, -45, -67.54, 8.3066},
                    TextInput.multiDoubleInput(5,null, null)
            )));
  }

  @Test
  void multiIntegerInput() throws Exception {
    muteSystemOut(() -> withTextFromSystemIn("53", "235", "-45", "-67", "2")
            .execute(() -> assertArrayEquals(
                    new int[]{53, 235, -45, -67, 2},
                    TextInput.multiIntegerInput(5,null, null)
            )));
  }

  @Test
  void newPasswordInput() {

  }

  @Test
  void pressEnterToContinue() throws Exception {
    String output = tapSystemOutNormalized(() -> withTextFromSystemIn("")
            .execute(() -> TextInput.pressEnterToContinue("question")));
    assertTrue(output.contains("question"));
  }
}
