import java.awt.*;
import java.util.*;
/**
* Trainer class that creates Trainer objects based off of the Entity class
*/
public class Trainer extends Entity {
  /**
  * Private variable that stores the Trainer's money as an integer
  */
	private int money = 25;
  /**
  * Private variable that stores the user's potions as an integer
  */
	private int potions = 1;
  /**
  * Private variables that stores the user's pokeballs as an integer
  */
	private int pokeballs = 5;
  /**
  * Private variable that stores the user's location as a Point data type
  */
	private Point loc;
  /**
  * Private variable that stores the initialized map as a Map object
  */
	private Map map;
  /**
  * Private variable that stores the user's pokemon into an ArrayList
  */
	private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
	
  /**
  * Constructor method that gives all pokemon 25 HP
  * @param n Pokemon's name as a string
  * @param p Pokemon added to a pokemon list
  * @param map1 Map object that is being utilized
  */
	public Trainer(String n, Pokemon p) {
		super(n, 25);
    pokemon.add(p);
	}
	/**
  *Returns the amount of money the user owns.
  */
	public int getMoney() {
		return money;
	}
	
  /**
  *Determines if user has enough money to spend.
  *@param amt Amount of money currently held by the user as an integer.
  */
	public boolean spendMoney(int amt) {
		if (money >= amt) {
      this.money -= amt;
      return true;
		}
		else {
      return false;
		}
	}
	
  /**
  *Increases money by amount recieved.
  *@param amt Amount of money currently held by the user as an integer.
  */
	public void receiveMoney(int amt) {
		money += amt;
	}

  /**
  *Checks if the user has a potion to use.
  */
	public boolean hasPotion() {
		if (potions >= 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
  /**
  *Rceieves one potion.
  */
	public void receivePotion() {
    this.potions += 1;
	}
	
  /**
  *Uses one potion.
  *@param pokeIndex Index of Pokemon list as an integer.
  */
	public void usePotion(int pokeIndex) {
		this.potions -= 1;
	}
	
  /**
  *Checks if the user has a pokeball to use.
  */
	public boolean hasPokeball() {
		if (pokeballs >= 1){
      return true;
    }
    else {
      return false;
    }
	}
	
  /**
  *Recieves one pokeball.
  */
	public void receivePokeball() {
      pokeballs += 1;
	}
	
  /**
  *Checks if the user has a pokeball to catch pokemon with.
  *@param p Pokemon that the user is attempting to catch.
  */
	public boolean catchPokemon(Pokemon p) {
    if (this.hasPokeball() == true){
      this.pokeballs -= 1;
      this.pokemon.add(p);
      return true;
    }
    else{
      System.out.println("Has no pokeballs");
      return false;
    }
	}
	
  /**
  * Returns the location of the user.
  */
	public Point getLocation() {
    if (this.loc == null) {
      this.loc = map.findStart();
      return this.loc;
    } else {
      return this.loc;  
    }
	}
	
  /**
  *Checks if the user is able to go north.
  *If user can go north they move up by one.
  *Previous character is replaced by "n".
  */
	public char goNorth() {
		if (this.loc.x -1 < 0){
      System.out.println("You cannot go that way.\n");
      return 'q';
    } else {
      this.map.reveal(this.loc);
      if (this.map.getCharAtLoc(this.loc) == 's' || this.map.getCharAtLoc(this.loc) == 'c' || this.map.getCharAtLoc(this.loc) == 'n' || this.map.getCharAtLoc(this.loc) == 'w') {
        this.loc.x -= 1;
        return map.getCharAtLoc(this.loc);
      } else {
        this.map.removeCharAtLoc(this.loc);
        this.loc.x -= 1;
        return map.getCharAtLoc(this.loc);
      }
    }
  }

	
  /**
  *Checks if the user is able to go south.
  *If user can go north they move down by one.
  *Previous character is replaced by "n".
  */
	public char goSouth() {
		if (this.loc.x + 1 > 4){
      System.out.println("You cannot go that way.\n");
      return 'q';
    } else {
      this.map.reveal(this.loc);
      if (this.map.getCharAtLoc(this.loc) == 's' || this.map.getCharAtLoc(this.loc) == 'c' || this.map.getCharAtLoc(this.loc) == 'n' || this.map.getCharAtLoc(this.loc) == 'w') {
        this.loc.x += 1;
        return map.getCharAtLoc(this.loc);
      } else {
        this.map.removeCharAtLoc(this.loc);
        this.loc.x += 1;
        return map.getCharAtLoc(this.loc);
      }
    }
  }
	
  /**
  *Checks if the user is able to go east.
  *If user can go north they move right by one.
  *Previous character is replaced by "n".
  */
	public char goEast() {
		if (this.loc.y + 1 > 4){
      System.out.println("You cannot go that way.\n");
      return 'q';
    } else {
      this.map.reveal(this.loc);
      if (this.map.getCharAtLoc(this.loc) == 's' || this.map.getCharAtLoc(this.loc) == 'c' || this.map.getCharAtLoc(this.loc) == 'n' || this.map.getCharAtLoc(this.loc) == 'w') {
        this.loc.y += 1;
        return map.getCharAtLoc(this.loc);
      } else {
        this.map.removeCharAtLoc(this.loc);
        this.loc.y += 1;
        return map.getCharAtLoc(this.loc);
      }
    }
	}
	
  /**
  *Checks if the user is able to go west.
  *If user can go north they move left by one.
  *Previous character is replaced by "n".
  */
	public char goWest() {
		if (this.loc.y - 1 < 0){
      System.out.println("You cannot go that way.\n");
      return 'q';
    } else {
      this.map.reveal(this.loc);
      if (this.map.getCharAtLoc(this.loc) == 's' || this.map.getCharAtLoc(this.loc) == 'c' || this.map.getCharAtLoc(this.loc) == 'n' || this.map.getCharAtLoc(this.loc) == 'w') {
        this.loc.y -= 1;
        return map.getCharAtLoc(this.loc);
      } else {
        this.map.removeCharAtLoc(this.loc);
        this.loc.y -= 1;
        return map.getCharAtLoc(this.loc);
      }
    }
  }
	
  /**
  *Returns the number of pokemon the user has.
  */
	public int getNumPokemon() {
		return pokemon.size();
	}
	
  /**
  *Heals all pokemon in user's party.
  */
	public void healAllPokemon() {
    Pokemon currentPoke;
		for (int i = 0; i < pokemon.size(); i++){
      currentPoke = pokemon.get(i);
      currentPoke.heal();
    }
	}
	
  /**
  *Returns a pokemon from the user's list of pokemon.
  *@param index Index represented as an integer to return a pokemon from the list.
  */
	public Pokemon getPokemon(int index) {
		return pokemon.get(index);
	}
	
  /**
  *Returns a list of your pokemon in order along wtih their current and max hp.
  */
	public String getPokemonList() {
    String pokeList = "";
		for (int i = 0; i < pokemon.size(); i++){
      String iStr = Integer.toString(i + 1);
      String hpStr = Integer.toString(pokemon.get(i).getHp());
      String maxhpStr = Integer.toString(pokemon.get(i).getMaxHp());
      pokeList += iStr + ". " + pokemon.get(i).getName() + " HP: " + hpStr + "/" + maxhpStr + "\n";
    }
    return pokeList;
	}
	
  /**
  *Returns the user's name and hp.
  *Returns the user's amount of money, potions, and pokeballs.
  */
	public String toString() {
    String trainerString = "";
    String hpStr = Integer.toString(this.getHp());
    String maxhpStr = Integer.toString(this.getMaxHp());
    String moneyStr = Integer.toString(this.getMoney());
    String potionsStr = Integer.toString(this.potions);
    String pokeballsStr = Integer.toString(this.pokeballs);
    trainerString += this.getName() + " HP: " + hpStr + "/" + maxhpStr + "\n";
    trainerString += "Money: " + moneyStr + "\n"; 
    trainerString += "Potions: " + potionsStr + "\n";
    trainerString += "Poke Balls: " + pokeballsStr + "\n";
    trainerString += "Pokemon\n-------\n";
    trainerString += this.getPokemonList();
    return trainerString;
  }
}