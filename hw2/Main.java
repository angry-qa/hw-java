package hw2;

import hw2.Unit.Teams;

public class Main {

  static Lizard lizard = new Lizard(Teams.KUPCHINO_LAIR);
  static Dragonfly dragonfly = new Dragonfly(Teams.HIVE_OF_PARNAS);

  public static void main(String[] args) {

    System.out.println("");
    System.out.println((char) 27 + "[35mWelcome to 'Heroes Of Might and Magic: UNREMAKE'" + (char)27 + "[0m");
    System.out.println("");

    lizard.setCurrentEnemy(dragonfly);
    dragonfly.setCurrentEnemy(lizard);

    while (lizard.getHealth() > 0 && dragonfly.getHealth() > 0) {
      action(lizard);
      action(dragonfly);
    }

    System.out.println("Гейм Овер!");

  }

  public static void action (Unit unit){
    unit.action();
  }

}