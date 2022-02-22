import java.util.*;
/**
* Responsible for storing the variables and methods for Water pokemon
*/
public class Water extends Pokemon {
  /**
  * Special menu to be displayed when the trainer wants to use a Water special attack
  */
  public Water(String n, int h, int m) {
    super(n, h, m);
  }

  @Override
  public String getAttackMenu(int atkType) {
    if (atkType == 1) {
      return "1. Slam\n2. Tackle\n3. Punch";
    } else {
      return "1. WaterGun\n2. BubbleBeam\n3. WaterFall";
    }
  }

  @Override
  public int getNumAttackMenuItems(int atkType) {
    return 3;
  }

  @Override
  public String getAttackString(int atkType, int move){
    String atkDescr = "";
    if (atkType == 1) {
      atkDescr = super.getAttackString(atkType, move); 
    }
    else {
      switch(move) {
        case 1:
          atkDescr += "WATER GUN"; 
          break;
        case 2:
          atkDescr += "BUBBLE BEAM";
          break;
        case 3:
          atkDescr += "WATER FALL";
          break;
      }
    }
    return atkDescr;
  }

  @Override
  public int getAttackDamage(int atkType, int move) {
    Random rand = new Random();
    int dmg = 0;
    if (atkType == 1) {
      dmg = super.getAttackDamage(atkType, move);
    }
    else {
      switch(move) {
        case 1:
          dmg = rand.nextInt(4) + 2;
          break;
        case 2:
          dmg = rand.nextInt(3) + 1;
          break;
        case 3:
          dmg = rand.nextInt(4) + 1;
          break;
      }
    }
    return dmg;
  }

  @Override
  public double getAttackMultiplier(Pokemon p, int atkType) {
    if (atkType == 1) {
      return super.getAttackMultiplier(p, 1); 
    }
    else {
      return battleTable[this.getType()][p.getType()];
    }
  }
}