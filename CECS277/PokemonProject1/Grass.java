/**
* Responsible for storing the variables and methods for Grass pokemon
*/
public interface Grass {
  /**
  * Special menu to be displayed when the trainer wants to use a Grass special attack
  */
  public String specialMenu = "1. Vine Whip\n2. Razor Leaf\n3. Solar Beam";
  /**
  * Number of special menu attacks
  */  
  public int numSpecialMenuItems = 3;
  /**
  * Vine whip special attack to Pokemon p
  */
  public String vineWhip(Pokemon p);
  /**
  * Razor leaf special attack to Pokemon p
  */  
  public String razorLeaf(Pokemon p);
  /**
  * Solar beam special attack to Pokemon p
  */
  public String solarBeam(Pokemon p);
}