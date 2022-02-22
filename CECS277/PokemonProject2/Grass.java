import java.util.*;
/**
* Responsible for storing the variables and methods for Grass pokemon
*/
public class Grass extends Pokemon {
  /**
  * Special menu to be displayed when the trainer wants to use a Grass special attack
  */

  public Grass(String n, int h, int m) {
    super(n, h, m);
  }

  @Override
  public String getAttackMenu(int atkType) {
    if (atkType == 1) {
      return super.getAttackMenu(atkType);
    } else {
      return "1. VineWhip\n2. RazorLeaf\n3. SolarBeam";
    }
  }

  @Override
  public int getNumAttackMenuItems(int atkType) {
    return super.getNumAttackMenuItems(atkType);
  }

  @Override
  public String getAttackString(int atkType, int move) {
    if (atkType == 1) {
      return super.getAttackString(atkType, move);
    } else {
      if (move == 1) {
        return "WHIPPED with a VINE";
      } else if (move == 2) {
        return "LEAFED with a RAZOR";
      } else {
        return "BEAMED with SOLAR";
      }
    }
  }

  @Override
  public int getAttackDamage(int atkType, int move) {
    Random rand = new Random();
    int randomInt;
    if (atkType == 1) {
      return super.getAttackDamage(atkType, move);
    } else {
      if (move == 1) {
        randomInt = rand.nextInt(3) + 1;
        return randomInt;
      } else if (move == 2) {
        randomInt = rand.nextInt(3) + 2;
        return randomInt;
      } else {
        randomInt = rand.nextInt(6);
        return randomInt;
      }
    }
  }

  @Override
  public double getAttackMultiplier(Pokemon p, int atkType) {
    return super.getAttackMultiplier(p, atkType);
  }
}