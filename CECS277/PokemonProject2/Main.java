import java.util.*;
import java.io.*;
/**
* Main class that is responsible for calling all classes and methods
* Contains many methods for progressing the game forward
*/
class Main {
  /**
  * Public method that moves the trainer in the specified direction
  * @param map1 Map object that is being utilized
  * @param p Trainer that the user is playing as
  * @param direction The direction that the user is specifying where to go
  */
  public static void mainMenu(Map map1, Trainer p, int direction){
    direction = CheckInput.getIntRange(1, 5);
    if (direction == 1) {
      char dir = p.goNorth();
      if (dir == 'q') {
        System.out.println("You cannot go that way.\n");
      }
    } else if (direction == 2) {
      char dir = p.goSouth();
      if (dir == 'q') {
        System.out.println("You cannot go that way.\n");
      }
    } else if (direction == 3) {
      char dir = p.goEast();
      if (dir == 'q') {
        System.out.println("You cannot go that way.\n");
      }
    } else if (direction == 4) {
      char dir = p.goWest();
      if (dir == 'q') {
        System.out.println("You cannot go that way.\n");
      }
    } else {
      System.out.println("GAME OVER");
      System.exit(0);
    }
    p.toString();
  }
  /**
  * Selects a random pokemon from the available six to pit against the user for battle.
  * @param p Trainer the user is playing as.
  */
  public static Pokemon chooseRandomPokemon(Trainer p, int mapLevel){
    PokemonGenerator newPoke = PokemonGenerator.getInstance();
    Pokemon randPoke = newPoke.generateRandomPokemon(mapLevel);
    return randPoke;
  }
  /**
  * Trainer attack method that attacks the wild pokemon given the user's decision
  * @param p Trainer the user is playing as
  * @param wildPokemon The wild pokemon that is being attacked
  * @param map1 Current map that is being used
  */
  public static void trainerAttack(Trainer p, Pokemon wildPokemon, Map map1) {
    boolean allZeroHP = false;
    int counter = 0;
    do {
      // Checks if all of the pokemon are 0 HP, sets boolean
      for (int i = 0; i < p.getNumPokemon(); i++) {
        if (p.getPokemon(i).getHp() == 0) {
          counter += 1;
        }
      }
      if (counter == p.getNumPokemon()) {
        allZeroHP = true;
      }
      // check if the wild pokemon is dead
      if (wildPokemon.getHp() == 0) {
        System.out.println("");
        System.out.println("You have successfully fainted " + wildPokemon.getName() + "!");
        p.receiveMoney(20);
        System.out.println("+$20 money has been rewarded to you.");
        System.out.println("");
        map1.removeCharAtLoc(p.getLocation());
        break;
      }
      // Pokemon attacks
      System.out.println(wildPokemon.getName() + " HP: " + wildPokemon.getHp() + "/" + wildPokemon.getMaxHp());
      System.out.println("What do you want to do?");
      System.out.println("1. Fight\n2. Use Potion\n3. Throw Poke Ball\n4. Run Away");
      int choice = CheckInput.getIntRange(1, 4);
      if (choice == 1) {
        // 1. fight
        System.out.println("Choose a Pokemon:");
        System.out.println(p.getPokemonList());
        int pokeChoice = CheckInput.getIntRange(1, p.getNumPokemon());
        Pokemon pChoice = p.getPokemon(pokeChoice - 1);
        // attack the user if they chose a pokemon with 0 hp
        if (pChoice.getHp() == 0) {
          System.out.println(pChoice.getName() + " has 0 HP!");
          Random rand = new Random();
          int randomTrainerDamage = rand.nextInt((6 - 1) + 1) + 1;
          p.takeDamage(randomTrainerDamage);
          System.out.println(wildPokemon.getName() + " has attacked you!");
          System.out.println("You took " + randomTrainerDamage + " damage!");
          System.out.println(p.getName() + ": Ouch! That really hurt!\n");
          break;
        }
        System.out.println(pChoice.getName() + ", I choose you!");
        System.out.println("Let's win this battle, " + pChoice.getName() + "!\n");
        System.out.println(pChoice.getAttackTypeMenu());
        int pokeAttackChoice = CheckInput.getIntRange(1, pChoice.getAttackTypeMenuItems());
        if (pokeAttackChoice == 1) {
          // basic attack
          System.out.println(pChoice.getAttackMenu(pokeAttackChoice));
          int basicChoice = CheckInput.getIntRange(1, pChoice.getNumAttackMenuItems(pokeAttackChoice));
          System.out.println(pChoice.attack(wildPokemon, pokeAttackChoice, basicChoice));
        } else {
          System.out.println(pChoice.getAttackMenu(pokeAttackChoice));
          int attackChoice = CheckInput.getIntRange(1, pChoice.getNumAttackMenuItems(pokeAttackChoice));
          System.out.println(pChoice.attack(wildPokemon, pokeAttackChoice, attackChoice));
        }
        // generate random number for wildPokemon's attack
        Random rand = new Random();
        int randAtk = rand.nextInt(2) + 1;
        int randMove = rand.nextInt(3) + 1;
        System.out.println(wildPokemon.attack(pChoice, randAtk, randMove));
      } else if (choice == 2) {
        // 2. use potion
        if (p.hasPotion() == true) {
          System.out.println("Choose a Pokemon to heal:");
          System.out.println(p.getPokemonList());
          int pokeHealChoice = CheckInput.getIntRange(1, p.getNumPokemon());
          Pokemon pHealChoice = p.getPokemon(pokeHealChoice - 1);
          pHealChoice.heal();
          p.usePotion(0);
          System.out.println(pHealChoice.getName() + " has been healed.");
          System.out.println(pHealChoice.getName() + " HP: " + pHealChoice.getHp() + "/" + pHealChoice.getMaxHp());
        } else {
          System.out.println("You have no potions.");
        }
      } else if (choice == 3) {
        // 3. throw poke ball
        System.out.println("Shake... Shake... Shake...");
        if (p.hasPokeball() == true) {
          boolean catchP = p.catchPokemon(wildPokemon);
          if (!catchP) {
            System.out.println("You were not able to catch " + wildPokemon.getName() + "!");
          } else {
            System.out.println("You caught " + wildPokemon.getName());
            if (p.getNumPokemon() == 7) {
              System.out.println("Since you have more than six Pokemon, you must remove one.");
              System.out.println("Which would you like to get rid of? (Choose 1-7)");
              System.out.println("");
              System.out.println(p.getPokemonList());
              int remove = CheckInput.getIntRange(1, 7);
              p.removePokemon(remove);
            }
            map1.removeCharAtLoc(p.getLocation());
            break;
          }
        } else {
          System.out.println("You have no pokeballs.");
        }
      } else {
        // 4. run away
        break;
      }
    } while (wildPokemon.getHp() != 0 || allZeroHP != true);
  }
  /**
  * City method that is called when the user enters a city
  * User can either enter a store or hospital
  * @param p Trainer that the user is playing as
  */
  public static void city(Trainer p) {
    System.out.println("You've entered the city.");
    System.out.println("Where would you like to go?");
    System.out.println("1. Store\n2. Pokemon Hospital");
    int cityDecision = CheckInput.getIntRange(1, 2);
    if (cityDecision == 1) {
      // store
      int storeDecision = 0;
      while (storeDecision != 3) {
        System.out.println("Hello! What can I help you with?");
        System.out.println("1. Buy Potions - $5\n2. Buy Poke Balls - $3\n3. Exit");
        storeDecision = CheckInput.getIntRange(1, 3);
        // potions
        if (storeDecision == 1) {
          if (p.getMoney() < 5) {
            System.out.println("Insufficient funds");
          } else {
            p.spendMoney(5);
            p.receivePotion();
            System.out.println("Here's your potion.");
          }
        } else if (storeDecision == 2) {
        // poke balls
          if (p.getMoney() < 3) {
            System.out.println("Insufficient funds");
          } else {
            p.spendMoney(3);
            p.receivePokeball();
            System.out.println("Here's your poke ball.");
          }
        }
      }
      System.out.println("Thank you, come again soon!");
      System.out.println("");
    } else {
      System.out.println("Hello! Welcome to the Pokemon Hospital.");
      System.out.println("I'll fix your poor pokemon up in a jiffy!");
      p.healAllPokemon();
      System.out.println("There you go! See you again soon.");
    }
  }

  public static boolean gym(Trainer p, Map map1, Pokemon wildPokemon) {
    boolean cont;
    System.out.println("You have entered the gym.");
    boolean allZeroHP = false;
    int counter = 0;
    do {
      // Checks if all of the pokemon are 0 HP, sets boolean
      for (int i = 0; i < p.getNumPokemon(); i++) {
        if (p.getPokemon(i).getHp() == 0) {
          counter += 1;
        }
      }
      if (counter == p.getNumPokemon()) {
        allZeroHP = true;
      }
      // check if the wild pokemon is dead
      if (wildPokemon.getHp() == 0) {
        System.out.println("");
        System.out.println("You have successfully fainted " + wildPokemon.getName() + "!");
        p.receiveMoney(20);
        System.out.println("+$20 money has been rewarded to you.");
        System.out.println("");
        System.out.println("You will now move on to a new map...");
        map1.removeCharAtLoc(p.getLocation());
        cont = true;
        return cont;
      }
      // Pokemon attacks
      System.out.println(wildPokemon.getName() + " HP: " + wildPokemon.getHp() + "/" + wildPokemon.getMaxHp());
      System.out.println("What do you want to do?");
      System.out.println("1. Fight\n2. Use Potion");
      int choice = CheckInput.getIntRange(1, 4);
      if (choice == 1) {
        // 1. fight
        System.out.println("Choose a Pokemon:");
        System.out.println(p.getPokemonList());
        int pokeChoice = CheckInput.getIntRange(1, p.getNumPokemon());
        Pokemon pChoice = p.getPokemon(pokeChoice - 1);
        // attack the user if they chose a pokemon with 0 hp
        if (pChoice.getHp() == 0) {
          System.out.println(pChoice.getName() + " has 0 HP!");
          Random rand = new Random();
          int randomTrainerDamage = rand.nextInt((6 - 1) + 1) + 1;
          p.takeDamage(randomTrainerDamage);
          System.out.println(wildPokemon.getName() + " has attacked you!");
          System.out.println("You took " + randomTrainerDamage + " damage!");
          System.out.println(p.getName() + ": Ouch! That really hurt!\n");
          break;
        }
        System.out.println(pChoice.getName() + ", I choose you!");
        System.out.println("Let's win this battle, " + pChoice.getName() + "!\n");
        System.out.println(pChoice.getAttackTypeMenu());
        int pokeAttackChoice = CheckInput.getIntRange(1, pChoice.getAttackTypeMenuItems());
        if (pokeAttackChoice == 1) {
          // basic attack
          System.out.println(pChoice.getAttackMenu(pokeAttackChoice));
          int basicChoice = CheckInput.getIntRange(1, pChoice.getNumAttackMenuItems(pokeAttackChoice));
          System.out.println(pChoice.attack(wildPokemon, pokeAttackChoice, basicChoice));
        } else {
          System.out.println(pChoice.getAttackMenu(pokeAttackChoice));
          int attackChoice = CheckInput.getIntRange(1, pChoice.getNumAttackMenuItems(pokeAttackChoice));
          System.out.println(pChoice.attack(wildPokemon, pokeAttackChoice, attackChoice));
        }
        // generate random number for wildPokemon's attack
        Random rand = new Random();
        int randAtk = rand.nextInt(2) + 1;
        int randMove = rand.nextInt(3) + 1;
        System.out.println(wildPokemon.attack(pChoice, randAtk, randMove));
      } else {
        // 2. use potion
        if (p.hasPotion() == true) {
          System.out.println("Choose a Pokemon to heal:");
          System.out.println(p.getPokemonList());
          int pokeHealChoice = CheckInput.getIntRange(1, p.getNumPokemon());
          Pokemon pHealChoice = p.getPokemon(pokeHealChoice - 1);
          pHealChoice.heal();
          p.usePotion(0);
          System.out.println(pHealChoice.getName() + " has been healed.");
          System.out.println(pHealChoice.getName() + " HP: " + pHealChoice.getHp() + "/" + pHealChoice.getMaxHp());
        } else {
          System.out.println("You have no potions.");
        }
      }
    } while (wildPokemon.getHp() != 0 || allZeroHP != true);
    cont = false;
    return cont;
  }

  /**
  * Method that is called when the user encoutners a random person
  * @param p Trainer that the user is playing as
  */
  public static void encounterRandomPerson(Trainer p) {
    Random rand = new Random();
    int randomNum = rand.nextInt((5 - 0) + 1) + 0;
    if (randomNum == 0) {
      System.out.println("A random person just gave you a free potion!");
      p.receivePotion();
    } else if (randomNum == 1) {
      System.out.println("A random person just gave you a free poke ball!");
      p.receivePokeball();
    } else if (randomNum == 2) {
      System.out.println("A random person just gave you +$10 money!");
      p.receiveMoney(10);
    } else if (randomNum == 3) {
      System.out.println("A random person just attacked you!");
    } else if (randomNum == 4) {
      System.out.println("Misty: Hey, " + p.getName() + "! Where is my bike?");
    } else {
      System.out.println("You run into Misty.");
      System.out.println("Misty: Where's my bike, twerp!");
      p.takeDamage(3);
      System.out.println("Misty SMACKS you for 3 damage");
    }
  }
  /**
  *Generates a random item for the player when they land on "i" in the map.
  *@param p Trainer the user is playing as.
  */
  public static void randomItem(Trainer p){
      int i = 0;
      List<Integer> givenList = Arrays.asList(0, 1);
	    Random rand = new Random();
	    int randomElement = givenList.get(rand.nextInt(givenList.size()));
      i = randomElement;
      if(i == 0){
        System.out.println("You found a pokeball!");
        p.receivePokeball();
      }
      else if (i == 1){
        System.out.println("You found a potion!");
        p.receivePotion();
      }
  }
  /**
  * Main method that is responsible for calling all external methods
  */
  public static void main(String[] args) {
    // Introduction messages and input
    System.out.println("Prof. Oak: Hello there new trainer, what is your name?");
    String name = CheckInput.getString();
    System.out.println("Great to meet you, " + name + "\nChoose your first pokemon:");
    System.out.println("1. Charmander" + "\n2. Bulbasaur" + "\n3. Squirtle");

    // Gather the starting pokemon using CheckInput class
    Pokemon poke1;
    PokemonGenerator newPoke = PokemonGenerator.getInstance();
    int starter_pokemon = CheckInput.getIntRange(1, 3);
    if (starter_pokemon == 1) {
      poke1 = newPoke.getPokemon("Charmander");
    } else if (starter_pokemon == 2) {
      poke1 = newPoke.getPokemon("Bulbasaur");
    } else {
      poke1 = newPoke.getPokemon("Squirtle");
    }
    
    // Initialize map and trainer
    Map map1 = Map.getInstance();
    Trainer person = new Trainer(name, poke1);
    map1.loadMap(1);
    int mapCounter = 1;
    // Print contents of person
    int direction = 0;
    while (direction != 5 && person.getHp() > 0) {
      System.out.println(person.toString());
      mainMenu(map1, person, direction);
      if (map1.getCharAtLoc(person.getLocation()) == 'c') {
        // user enters a city
        city(person);
      } else if (map1.getCharAtLoc(person.getLocation()) == 'p') {
        // user encounters a random person
        encounterRandomPerson(person);
      } else if (map1.getCharAtLoc(person.getLocation()) == 'w') {
        // user comes across a wild pokemon
        Pokemon wildPokemon = chooseRandomPokemon(person, mapCounter);
        System.out.println("A wild " + wildPokemon.getName() + " has appeared.");
        trainerAttack(person, wildPokemon, map1);
      } else if (map1.getCharAtLoc(person.getLocation()) == 'i') {
        // user collects a random item
        randomItem(person);
      } else if (map1.getCharAtLoc(person.getLocation()) == 'n') {
        // user encounters nothing
        System.out.println("There's nothing here...");
      } else if (map1.getCharAtLoc(person.getLocation()) == 'f') {
        Pokemon wildPokemon = chooseRandomPokemon(person, mapCounter);
        boolean cont = gym(person, map1, wildPokemon);
        if (cont == true) {
          // triggers the loading of a new map
          if (mapCounter == 1) {
            mapCounter += 1;
            map1.loadMap(2);
          } else if (mapCounter == 2) {
            mapCounter += 1;
            map1.loadMap(3);
          } else {
            mapCounter = 1;
            map1.loadMap(1);
          }
        }
      } 
    }
  }
}