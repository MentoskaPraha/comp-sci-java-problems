package com.mentoskapraha.comp_sci.assignments;

import com.mentoskapraha.comp_sci.common.Assignment;

public class MacdonaldFarm extends Assignment {
  public MacdonaldFarm() {
    this.name = "Macdonald Farm";
  }

  @Override
  public void run() {
    //output all verses of the song
    outputVerse("cow", "moo");
    outputVerse("pig", "oink");
    outputVerse("duck", "quack");
    outputVerse("hen", "cluck");
    outputVerse("sheep", "baa");
  }

  /**
   * Outputs a verse of Old Macdonald had a Farm to the System Output
   * with the animal and animal sounds specified by this method
   * @param animal The animal that's in the verse, for example: 'cow'
   * @param animalSound The sound the animal make, for example: 'moo'
   */
  private static void outputVerse(String animal, String animalSound){
    System.out.println("Old MacDonald had a farm, E-I-E-I-O,\n" +
            "And on his farm he had a " + animal + ", E-I-E-I-O,\n" +
            "With a " + animalSound + "-" + animalSound + " here and a " + animalSound + "-" + animalSound + " there,\n" +
            "Here a " + animalSound + ",\n" +
            "there a " + animalSound + ",\n" +
            "everywhere " + animalSound + "-" + animalSound + ",\n" +
            "Old MacDonald had a farm, E-I-E-I-O.\n"
    );
  }
}
