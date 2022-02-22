import java.util.Random;
/**
* Class for the Bulbasaur Pokemon
* Is a subclass for the Pokemon class
* Implements the Grass type interface
*/
public class Bulbasaur extends Pokemon implements Grass {
  /**
  * Constructor method for initializing the name
  */
  public Bulbasaur(){
    super("Bulbasaur");
  }
  /**
  * Public method that returns Bulbasaur's special menu
  */
  public String getSpecialMenu(){
    return Grass.specialMenu;
  }
  /**
  * Public method that returns the number of the Bulbasaur's special attacks
  */
  public int getNumSpecialMenuItems(){
    return Grass.numSpecialMenuItems;
  }
  /**
  * Public method that enacts Bulbasaur's special attack
  * @param p Pokemon that is being attacked
  * @param move The number of the special attack being enacted
  */
  public String specialAttack(Pokemon p, int move){
    if (move == 1) {
      return vineWhip(p); 
    } else if (move == 2) {
      return razorLeaf(p);
    } else if (move == 3) {
      return solarBeam(p);
    } else {
      return "Invalid move.";
    }
  }
  /**
  * Vine whip attack method
  * @param p Pokemon that is being attacked
  */
  public String vineWhip(Pokemon p){
    int type = p.getType();
    double multiplier = 0;
    if(type == 0){
      multiplier = battleTable[2][0];
    } else if (type == 1) {
      multiplier = battleTable[2][1];
    } else if (type == 2) {
      multiplier = battleTable[2][2];
    }
    Random rand = new Random();
    int randomInt = rand.nextInt(3);
    double damageD = multiplier * (randomInt + 1);
    int damageInt = (int) damageD;
    p.takeDamage(damageInt);
    return p.getName() + " is WHIPPED with a VINE and takes " + damageInt + " damage.";
  }
  /**
  * Razor leaf attack method
  * @param p Pokemon that is being attacked
  */
  public String razorLeaf(Pokemon p){
    int type = p.getType();
    double multiplier = 0;
    if(type == 0){
      multiplier = battleTable[2][0];
    } else if (type == 1) {
      multiplier = battleTable[2][1];
    } else if (type == 2) {
      multiplier = battleTable[2][2];
    }
    Random rand = new Random();
    int randomInt = rand.nextInt(3);
    double damageD = multiplier * (randomInt + 2);
    int damageInt = (int)damageD;
    p.takeDamage(damageInt);
    return p.getName() + " is RAZORED with a LEAF and takes " + damageInt + " damage.";
  }
  /**
  * Solar beam attack method
  * @param p Pokemon that is being attacked
  */
  public String solarBeam(Pokemon p){
    int type = p.getType();
    double multiplier = 0;
    if(type == 0){
      multiplier = battleTable[2][0];
    } else if (type == 1) {
      multiplier = battleTable[2][1];
    } else if (type == 2) {
      multiplier = battleTable[2][2];
    }
    Random rand = new Random();
    int randomInt = rand.nextInt(6);
    double damageD = multiplier * randomInt;
    int damageInt = (int)damageD;
    p.takeDamage(damageInt);
    return p.getName() + " is BEAMED with SOLAR and takes " + damageInt + " damage.";
  }
}