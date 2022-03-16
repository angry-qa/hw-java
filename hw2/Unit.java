package hw2;

import java.util.Random;

public abstract class Unit implements UnitInterface {

  public enum Teams {KUPCHINO_LAIR, HIVE_OF_PARNAS}

  private String  name;
  private Integer minDamage;
  private Integer maxDamage;
  private Integer attackRange;
  private Integer defence;
  private Integer health;
  private Integer speed;
  private Integer specialAbilityCount;
  private Unit    currentEnemy;
  private Integer xCoord;
  private Teams   team;

  protected Unit(String name, Integer minDamage, Integer maxDamage, Integer attackRange,
      Integer defence, Integer health, Integer speed, Teams team) {

    this.name = name;
    this.minDamage = minDamage;
    this.maxDamage = maxDamage;
    this.attackRange = attackRange;
    this.defence = defence;
    this.health = health;
    this.speed = speed;
    this.team = team;
    specialAbilityCount = 1;

    if (team == Teams.KUPCHINO_LAIR) {
      xCoord = 0;
    } else if (team == Teams.HIVE_OF_PARNAS) {
      xCoord = 25;
    }

  }

  public Integer getAttackRange() {
    return attackRange;
  }

  public void setAttackRange(Integer attackRange) {
    this.attackRange = attackRange;
  }

  public Integer getDefence() {
    return defence;
  }

  public void setDefence(Integer defence) {
    this.defence = defence;
  }

  public Integer getHealth() {
    return health;
  }

  public void setHealth(Integer health) {
    this.health = health;
  }

  public Integer getSpeed() {
    return speed;
  }

  public void setSpeed(Integer speed) {
    this.speed = speed;
  }

  public Unit getCurrentEnemy() {
    return currentEnemy;
  }

  public void setCurrentEnemy(Unit currentEnemy) {
    this.currentEnemy = currentEnemy;
  }

  public Integer getxCoord() {
    return xCoord;
  }

  public void setxCoord(Integer xCoord) {
    this.xCoord = xCoord;
  }

  public Teams getTeam() {
    return team;
  }

  public void setTeam(Teams team) {
    this.team = team;
  }

  public Integer getMinDamage() {
    return minDamage;
  }

  public void setMinDamage(Integer minDamage) {
    this.minDamage = minDamage;
  }

  public Integer getMaxDamage() {
    return maxDamage;
  }

  public void setMaxDamage(Integer maxDamage) {
    this.maxDamage = maxDamage;
  }

  public Integer diceRoll(Integer min, Integer max, Boolean anounce) {
    Random rnd = new Random();
    int value  =  min +  rnd.nextInt(max - min + 1);
    if (anounce){
      System.out.println(player() + " бросает кости. На кубиках: " + value);
    }
    return value;
  }

  public String player() {
    return name + " из команды " + team;
  }

  @Override
  public void attack() {
    if (specialAbilityCount == 1 && diceRoll(0, 1, false) == 1) {
      useAbility();
    } else {
      Integer damage = diceRoll(minDamage, maxDamage, true);
      System.out.println(player() + " атакует. В противника летит урон: " + damage);
      currentEnemy.defend(damage);
    }
  }

  @Override
  public void defend(Integer damage) {

    Integer dmg = damage;
    if (dmg > defence) {
      dmg -= defence;
      defence = 0;
    } else if (dmg < defence) {
      defence -= dmg;
      dmg = 0;
    } else {
      defence = 0;
      dmg = 0;
    }

    health -= dmg;

    if (health > 0) {
    System.out.println(player() + " держит удар и собирается дать отпор. Здоровье: " + health + ", защита: " + defence);
    } else {
     die();
    }

  }

  @Override
  public void move() {

    Integer step = diceRoll(1, speed, true);

    if (team == Teams.KUPCHINO_LAIR) {
      if (xCoord + step >= currentEnemy.xCoord) {
        xCoord = currentEnemy.xCoord - 1;
      } else if (xCoord + step > 25) {
        xCoord = 25;
      } else  {
        xCoord += step;
      }
    }

   if (team == Teams.HIVE_OF_PARNAS) {
      if (xCoord - step <= currentEnemy.xCoord) {
        xCoord = currentEnemy.xCoord + 1;
      } else if (xCoord - step < 0) {
        xCoord = 0;
      } else  {
        xCoord -= step;
      }
  }

    System.out.println(player() + " занимает клетку: " + xCoord);
  }

  @Override
  public void identifyEnemy() {
    System.out.println(player() + " знает своего врага. Это " + currentEnemy.name);
  }

  @Override
  public void die() {
    System.out.println((char) 27 + "[31m" + player() + " погибает. Покойся с миром " + name + (char)27 + "[0m");
    currentEnemy.setCurrentEnemy(null);
  }

  public Integer getSpecialAbilityCount() {
    return specialAbilityCount;
  }

  public void setSpecialAbilityCount(Integer specialAbilityCount) {
    this.specialAbilityCount = specialAbilityCount;
  }

  @Override
  public void action() {

    if (currentEnemy == null || health <= 0 || currentEnemy.health <= 0) {
      return;
    }

    if (team == Teams.KUPCHINO_LAIR) {
      System.out.println((char) 27 + "[32mХодит " + player() + (char)27 + "[0m");
      if (xCoord + attackRange < currentEnemy.xCoord) {
        move();
      } else {
        attack();
      }
    }

    if (team == Teams.HIVE_OF_PARNAS) {
      System.out.println((char) 27 + "[33mХодит " + player() + (char)27 + "[0m");
      if (xCoord - attackRange > currentEnemy.xCoord) {
        move();
      } else {
        attack();
      }
    }

    System.out.println("");

  }

}
