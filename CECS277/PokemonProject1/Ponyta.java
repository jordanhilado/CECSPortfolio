import java.util.Random;
/**
* Class for the Ponyta Pokemon
* Is a subclass for the Pokemon class
* Implements the Grass type interface
*/
public class Ponyta extends Pokemon implements Fire{
  /**
  * Constructor method for initializing the name
  */
  public Ponyta(){
    super("Ponyta");
  }
  /**
  * Public method that returns Ponyta's special menu
  */
  public String getSpecialMenu(){
    return Fire.specialMenu;
  }
  /**
  * Public method that returns the number of the Ponyta's special attacks
  */
  public int getNumSpecialMenuItems(){
    return Fire.numSpecialMenuItems;
  }
  /**
  * Public method that enacts Ponyta's special attack
  * @param p Pokemon that is being attacked
  * @param move The number of the special attack being enacted
  */
  public String specialAttack(Pokemon p, int move){
    if (move == 1) {
      return ember(p); 
    } else if (move == 2) {
      return fireBlast(p);
    } else if (move == 3) {
      return firePunch(p);
    } else {
      return "Invalid move.";
    }
  }
  /**
  * Ember attack method
  * @param p Pokemon that is being attacked
  */
  public String ember(Pokemon p){
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
    double damageD = multiplier * (randomInt);
    int damageInt = (int) damageD;
    p.takeDamage(damageInt);
    return p.getName() + " is attacked with EMBER and takes " + damageInt + " damage.";
  }
  /**
  * Fire blast attack method
  * @param p Pokemon that is being attacked
  */
  public String fireBlast(Pokemon p){
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
    double damageD = multiplier * (randomInt + 2);
    int damageInt = (int)damageD;
    p.takeDamage(damageInt);
    return p.getName() + " is BLASTED with FIRE and takes " + damageInt + " damage.";
  }
  /**
  * Fire punch attack method
  * @param p Pokemon that is being attacked
  */
  public String firePunch(Pokemon p){
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
    return p.getName() + " is PUNCHED with FIRE and takes " + damageInt + " damage.";
  }
}