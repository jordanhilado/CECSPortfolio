/**
* Responsible for storing the variables and methods for Water pokemon
*/
public interface Water{
  /**
  * Special menu to be displayed when the trainer wants to use a Water special attack
  */
  public String specialMenu = "1. Water Gun\n2. Bubble Beam\n3. Waterfall";
  /**
  * Number of special menu attacks
  */
  public int numSpecialMenuItems = 3;
  /**
  * Water gun special attack to Pokemon p
  */
  public String waterGun(Pokemon p);
  /**
  * Bubble beam special attack to Pokemon p
  */
  public String bubbleBeam(Pokemon p);
  /**
  * Waterfall special attack to Pokemon p
  */  
  public String waterfall(Pokemon p);
}