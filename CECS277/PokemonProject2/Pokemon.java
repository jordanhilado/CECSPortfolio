import java.util.Random;
/* Abstract classes cannot be instantiated,
i.e. we cannot create objects of type Pokemon */

/**
* Abstract class responsible for creating Pokemon objects
* Extends the Entity class
*/
public abstract class Pokemon extends Entity {
  /**
  * Public variable that stores the multiplier values for each pokemon type
  */
  public static final double [][] battleTable = {{1, 0.5, 2}, {2, 1, 0.5}, {0.5, 2, 1}};
  /**
  * Constructor method that gives all pokemon 25 HP
  * @param n Pokemon's name as a string
  */
  public Pokemon(String n, int h, int m) {
    super(n, h, m);
  }
  /**
  * Public method that returns the attack menu
  */
  public String getAttackMenu(int atkType) {
    if (atkType == 1) {
      return "1. Slam\n2. Tackle\n3. Punch";
    } else {
      return "";
    }
  }

  public String getAttackTypeMenu() {
    return "1. Basic Attack\n2. Special Attack";
  }

  public int getAttackTypeMenuItems() {
    return 2;
  }

  public String getAttackString(int atkType, int move) {
    if (atkType == 1) {
      if (move == 1) {
        return "SLAMMED";
      } else if (move == 2) {
        return "TACKLED";
      } else {
        return "PUNCHED";
      }
    } else {
      if (move == 1) {
        return "";
      } else if (move == 2) {
        return "";
      } else {
        return "";
      }
    }
  }

  public int getAttackDamage(int atkType, int move) {
    Random rand = new Random();
    double damageD;
    int randomInt;
    if (atkType == 1) {
      if (move == 1) {
        randomInt = rand.nextInt(6);
        damageD = randomInt + 1;
      } else if (move == 2) {
        randomInt = rand.nextInt(2);
        damageD = randomInt + 2;
      } else {
        randomInt = rand.nextInt(4);
        damageD = randomInt + 1;
      }
      int damageInt = (int)damageD;
      return damageInt;
    } else {
      return 0;
    }
  }

  public double getAttackMultiplier(Pokemon p, int atkType) {
    if (atkType == 1) {
      return 1;
    } else {
      int r = this.getType();
      int c = p.getType();
      return battleTable[r][c];
    }
  }

  public int getAttackBonus(int atkType) {
    return 0;
  }

  public String attack(Pokemon p, int atkType, int move) {
    String pokemonName = p.getName();
    int damage = (int)(this.getAttackDamage(atkType, move) * this.getAttackMultiplier(p, atkType));
    p.takeDamage(damage);
    return pokemonName + " is " + this.getAttackString(atkType, move) + " and takes " + damage + " damage.";
  }

  /**
  * Public method that returns the number of types of attacks that can be done
  */
  public int getNumAttackMenuItems(int atkType) {
    return 3;
  }
  /**
  * Public method that returns the number type of the current Pokemon
  */
  public int getType() {
    if (this instanceof Fire == true) {
      return 0;
    } else if (this instanceof Water == true) {
      return 1;
    } else {
      return 2;
    }
  }
}