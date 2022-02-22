import java.util.*;
public abstract class PokemonDecorator extends Pokemon {
  private Pokemon pokemon;
  /**
  *Decorator class decorates pokemon types with different types of buffs and debuffs to update the pokemon's stats
  */
  public PokemonDecorator(Pokemon p, String extraName, int extraHp) {
    super(p.getName(), p.getHp(), p.getMaxHp());
    pokemon = p;
  }
  /**
  *Public method that returns the attack type options for either basic attack or special
  *@param atkType Two types of attacking moves, basic or speciall attack
  */
  public String getAttackMenu(int atkType) {
      if (atkType == 1) {
      return "1. Slam\n2. Tackle\n3. Punch";
    } 
    else {
      return "";
    }
  } 
  /**
  *Public method that returns the number of moves in the above menu unless the move being used is special
  *@param atkType Two types of attacking moves, basic or speciall attack
  */
  public int getNumAttackMenuItems(int atkType) {
    return super.getNumAttackMenuItems(atkType);
  }
  /**
  *Public method that returns the print format of the attacking moves
  *@param atkType Two types of attacking moves, basic or speciall attack
  *@param move The individual move a pokemon uses to attack
  */
  public String getAttackString(int atkType, int move) {
    if (atkType == 1){
      return super.getAttackString(1, move);
    }
    else{
      return pokemon.getAttackString(atkType, move);
    }
  }
  /**
  *Public method that returns the randomized damage number for a given move, overriden by special type attacks
  *@param atkType Two types of attacking moves, basic or speciall attack
  *@param move The individual move a pokemon uses to attack
  */
  public int getAttackDamage(int atkType, int move) {
    if (atkType == 1){
      return super.getAttackDamage(1, move);
    }
    else{
      return pokemon.getAttackDamage(atkType, move);
    }
  }
  /**
  *Public method that returns the attack multiplier for a given move, overriden by special type attaks and buffs/debuffs
  *@param p Pokemon added to a pokemon list
  *@param atkType Two types of attacking moves, basic or speciall attack
  */
  public double getAttackMultiplier(Pokemon p, int atkType) {
    if (atkType == 1){
      return super.getAttackMultiplier(p, 1);
    }
    else{
      return pokemon.getAttackMultiplier(p, atkType);
    }
    }
  /**
  *Public method that returns the attack bonus of a move to calculate the final damage, overriden by special type attacks and buffs/debuffs
  *@param atkType Two types of attacking moves, basic or speciall attack
  */
  public int getAttackBonus(int atkType) {
    if (atkType == 1){
      return super.getAttackBonus(1);
    }
    else{
      return pokemon.getAttackBonus(atkType);
    }
  }
  /**
  *Public method that returns the integer type of a corresponding pokemon
  */
  public int getType() {
    return super.getType();
  }
}