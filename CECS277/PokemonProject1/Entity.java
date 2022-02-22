/**
* Abstract class that contains the variables and methods for all Pokemon and Trainers
*/
public abstract class Entity{
  /**
  * Private variable that stores the name as a String
  */
  private String name;
  /**
  * Private variable that stores the HP as an integer
  */
  private int hp;
  /**
  * Private variable that stores the max HP as an integer
  */
  private int maxHp;
  /**
  * Constructor method that stores the name and maxHP
  * Sets the current HP as the max HP
  *@param n passes for name for object
  *@param mHp max health for object 
  */
  public Entity(String n, int mHp){
    this.name = n;
    this.hp = mHp;
    this.maxHp = mHp;
  }
  /**
  * Public method that returns the current HP
  *@return hp for object
  */
  public int getHp() {
    return this.hp;
  }
  /**
  * Public method that returns the max HP
  *@return maxHp for health
  */
  public int getMaxHp() {
    return this.maxHp;
  }
  /**
  * Public method that subtracts the damage from the entity's HP
  * @param d Damage done to the pokemon as an integer
  */
  public void takeDamage(int d) {
    this.hp -= d;
    if (this.hp < 0) {
			this.hp = 0;
		}
  }
  /**
  * Public method that heals the current entity
  */
  public void heal() {
    int remain = this.maxHp - this.hp;
    this.hp += remain;
  }
  /**
  * Public method that returns the name of the entity
  @return name for object's name
  */
  public String getName() {
    return this.name;
  }
  /**
  * Public method that returns the HP status of the entity
  *@return hp as string of name, hp, and maxhp
  */
  public String toString() {
    String hp = name + " HP: " + getHp() + "/" + getMaxHp() + "\n";
    return hp;
  }
}