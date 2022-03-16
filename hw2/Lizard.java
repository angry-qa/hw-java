package hw2;

public class Lizard extends Unit {

  public Lizard(Teams team) {
    super("Ящер", 2, 3, 5,
        6, 14, 4, team);
  }

  @Override
  public void useAbility() {
    System.out.println(player() + " юзает суперспособность и становится сильнее на 4");
    setMinDamage(getMinDamage() + 4);
    setMaxDamage(getMaxDamage() + 4);
    setSpecialAbilityCount(0);
  }

}
