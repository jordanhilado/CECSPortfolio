import java.util.Random;
/**
* Class for the Staryu Pokemon
* Is a subclass for the Pokemon class
* Implements the Grass type interface
*/
public class Staryu extends Pokemon implements Water{
  /**
  * Constructor method for initializing the name
  */
  public Staryu(){
    super("Staryu");
  }
  /**
  * Public method that returns Staryu's special menu
  */
  public String getSpecialMenu(){
    return Water.specialMenu;
  }
  /**
  * Public method that returns the number of the Staryu's special attacks
  */
  public int getNumSpecialMenuItems(){
    return Water.numSpecialMenuItems;
  }
  /**
  * Public method that enacts Staryu's special attack
  * @param p Pokemon that is being attacked
  * @param move The number of the special attack being enacted
  */
  public String specialAttack(Pokemon p, int move){
    if (move == 1) {
      return waterGun(p); 
    } else if (move == 2) {
      return bubbleBeam(p);
    } else if (move == 3) {
      return waterfall(p);
    } else {
      return "Invalid move.";
    }
  }
  /**
  * Water gun attack method
  * @param p Pokemon that is being attacked
  */ 
  public String waterGun(Pokemon p){
    int type = p.getType();
    double multiplier = 0;
    if(type == 0){
      multiplier = battleTable[0][0];
    } else if (type == 1) {
      multiplier = battleTable[0][1];
    } else if (type == 2) {
      multiplier = battleTable[0][2];
    }
    Random rand = new Random();
    int randomInt = rand.nextInt(5);
    double damageD = multiplier * (randomInt + 1);
    int damageInt = (int) damageD;
    p.takeDamage(damageInt);
    return p.getName() + " is GUNNED with WATER and takes " + damageInt + " damage.";
  }
  /**
  * Bubble beam attack method
  * @param p Pokemon that is being attacked
  */
  public String bubbleBeam(Pokemon p){
    int type = p.getType();
    double multiplier = 0;
    if(type == 0){
      multiplier = battleTable[0][0];
    } else if (type == 1) {
      multiplier = battleTable[0][1];
    } else if (type == 2) {
      multiplier = battleTable[0][2];
    }
    Random rand = new Random();
    int randomInt = rand.nextInt(2);
    double damageD = multiplier * (randomInt + 1);
    int damageInt = (int)damageD;
    p.takeDamage(damageInt);
    return p.getName() + " is BEAMED with BUBBLES and takes " + damageInt + " damage.";
  }
  /**
  * Waterfall attack method
  * @param p Pokemon that is being attacked
  */
  public String waterfall(Pokemon p){
    int type = p.getType();
    double multiplier = 0;
    if(type == 0){
      multiplier = battleTable[0][0];
    } else if (type == 1) {
      multiplier = battleTable[0][1];
    } else if (type == 2) {
      multiplier = battleTable[0][2];
    }
    Random rand = new Random();
    int randomInt = rand.nextInt(4);
    double damageD = multiplier * (randomInt + 1);
    int damageInt = (int)damageD;
    p.takeDamage(damageInt);
    return p.getName() + " is HURT with WATERFALL and takes " + damageInt + " damage.";
  }
}