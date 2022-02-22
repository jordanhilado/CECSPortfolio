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
  public Pokemon(String n) {
    super(n, 25);
  }
  /**
  * Abstract method that calls the Pokemon's special menu
  */
  public abstract String getSpecialMenu();
  /**
  * Abstract method that calls the Pokemon's number of special attacks
  */
  public abstract int getNumSpecialMenuItems();
  /**
  * Abstract method that enacts the special attack
  * @param p Pokemon that is being attacked
  * @param move The decision for which special attack is being done
  */
  public abstract String specialAttack(Pokemon p, int move);
  /**
  * Public method that returns the basic menu of the Pokemon
  */
  public String getBasicMenu() {
    return basicAttackMenu();
  }
  /**
  * Public method that returns the number of basic attacks
  */
  public int getNumBasicMenuItems(){
    return 3;
  }
  /**
  * Public method that enacts the basic attack
  * @param p Pokemon that is being attacked
  * @param move The decision for which special attack is being done
  */
  public String basicAttack(Pokemon p, int move) {
    if (move == 1) {
      return slam(p);
    } else if (move == 2) {
      return tackle(p);
    } else if (move == 3) {
      return punch(p);
    } else {
      return "Invalid move.";
    }
  }
  /**
  * Public method that returns the attack menu
  */
  public String getAttackMenu() {
    return "1. Basic Attack\n2. Special Attack";
  }
  /**
  * Public method that returnst he basic attack menu
  */
  public String basicAttackMenu(){
    return "1. Slam\n2. Tackle\n3. Punch";
  }
  /**
  * Public method that returns the number of types of attacks that can be done
  */
  public int getNumAttackMenuItems() {
    return 2;
  }
  /**
  * Public method that slams the pokemon
  * @param p Pokemon that is being attacked
  */
  public String slam(Pokemon p) {
    int defenderType = p.getType();
    int attackerType = this.getType();
    Random rand = new Random();
    int randomInt = rand.nextInt(6);
    String pokemonName = p.getName();
    double multiplier = battleTable[attackerType - 1][defenderType - 1];
    double damageD = multiplier * (randomInt + 1);
    int damageInt = (int)damageD;
    p.takeDamage(damageInt);
    return pokemonName + " is SLAMMED and takes " + damageInt + " damage.";
  }
  /**
  * Public method that tackles the pokemon
  * @param p Pokemon that is being attacked
  */
  public String tackle(Pokemon p) {
    int defenderType = p.getType();
    int attackerType = this.getType();
    Random rand = new Random();
    int randomInt = rand.nextInt(2);
    String pokemonName = p.getName();
    double multiplier = battleTable[attackerType - 1][defenderType - 1];
    double damageD = multiplier * (randomInt + 2);
    int damageInt = (int)damageD;
    p.takeDamage(damageInt);
    return pokemonName + " is TACKLED and takes " + damageInt + " damage.";
  }
  /**
  * Public method that punches the pokemon
  * @param p Pokemon that is being attacked
  */
  public String punch(Pokemon p) {
    int defenderType = p.getType();
    int attackerType = this.getType();
    Random rand = new Random();
    int randomInt = rand.nextInt(4);
    String pokemonName = p.getName();
    double multiplier = battleTable[attackerType - 1][defenderType - 1];
    double damageD = multiplier * (randomInt + 1);
    int damageInt = (int)damageD;
    p.takeDamage(damageInt);
    return pokemonName + " is PUNCHED and takes " + damageInt + " damage.";
  }
  /**
  * Public method that returns the number type of the current Pokemon
  */
  public int getType() {
    if (this instanceof Fire == true) {
      return 1;
    } else if (this instanceof Water == true) {
      return 2;
    } else if (this instanceof Grass == true) {
      return 3;
    } else {
      return 0;
    }
  }
}