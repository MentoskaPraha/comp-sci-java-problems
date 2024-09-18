package com.mentoskapraha.comp_sci.common;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class full of useful utility functions.
 * @author MentoskaPraha
 */
public class Utils {
  /**
   * Gets a random integer.
   * @param min The smallest integer.
   * @param max The largest integer.
   * @return The randomly generated integer.
   * @author MentoskaPraha
   */
  public static int getRandomNumber(int min, int max){
    if(max < min) throw new IllegalArgumentException("max can't be smaller than min!");

    ArrayList<Integer> list = new ArrayList<>();
    for (int i = min; i < max; i++) list.add(i);
    Collections.shuffle(list);

    return list.get(0);
  }
}
