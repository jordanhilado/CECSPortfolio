/**
* Responsible for storing the variables and methods for Fire pokemon
*/
public interface Fire {
  /**
  * Special menu to be displayed when the trainer wants to use a Fire special attack
  */
  public String specialMenu = "1. Ember\n2. Fire Blast\n3. Fire Punch";
  /**
  * Number of special menu attacks
  */
  public int numSpecialMenuItems = 3;
  /**
  * Ember special attack to Pokemon p
  */
  public String ember(Pokemon p);
  /**
  * Fire blast special attack to Pokemon p
  */
  public String fireBlast(Pokemon p);
  /**
  * Fire punch special attack to Pokemon p
  */
  public String firePunch(Pokemon p);
}