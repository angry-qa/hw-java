package hw2;

public class Dragonfly extends Unit {

  public Dragonfly(Teams team) {
    super("Стрекоза", 2, 5,8,
        10, 20, 13, team);
  }

  @Override
  public void useAbility() {
    System.out.println(player() + " юзает суперспособность, разрушая на враге оставшуюся броню");
    getCurrentEnemy().setDefence(0);
    setSpecialAbilityCount(0);
  }

}
