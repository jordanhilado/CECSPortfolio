import java.util.*;
/**
* Responsible for storing the variables and methods for Fire pokemon
*/
public class Fire extends Pokemon {
  /**
  * Special menu to be displayed when the trainer wants to use a Fire special attack
  */

  public Fire(String n, int h, int m) {
    super(n, h, m);
  }

  @Override
  public String getAttackMenu(int atkType) {
    if (atkType == 1) {
      return "1. Slam\n2. Tackle\n3. Punch";
    } else {
      return "1. Ember\n2. FireBlast\n3. FirePunch";
    }
  } 

  public int getNumAttackMenuItems(int atkType) {
    return super.getNumAttackMenuItems(atkType);
  }

  public String getAttackString(int atkType, int move) {
      if (atkType == 1) {
      return super.getAttackString(atkType, move);
    } 
    else {
      if (move == 1) {
        return "EMBERED!";
      } 
      else if (move == 2) {
        return "FIREBLASTED!";
      } 
      else {
        return "FIREPUNCHED!";
      }
    }
  }

  public int getAttackDamage(int atkType, int move) {
    Random random = new Random();
    int randNum;
    if (atkType == 1){
      return super.getAttackDamage(atkType, move);
    }
      else{ 
        if (move == 1) {
        randNum = random.nextInt(3) + 1;
        return randNum;
      } 
      else if (move == 2) {
        randNum = random.nextInt(3) + 2;
        return randNum;
      } 
      else{
        randNum = random.nextInt(6);
        return randNum;
      }
      }
  }

  public double getAttackMultiplier(Pokemon p, int atkType) {
    return super.getAttackMultiplier(p, atkType);
  }


}