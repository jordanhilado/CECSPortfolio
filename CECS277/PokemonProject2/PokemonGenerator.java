import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PokemonGenerator {

  private HashMap<String, String> pokemon = new HashMap<>();

  private static PokemonGenerator instance = null;

  private PokemonGenerator() {
    try {
      File in = new File("PokemonList.txt"); 
      Scanner br = new Scanner(in);
      Pattern ex = Pattern.compile("(\\w+),(\\w+)");
      Matcher match;
      while (br.hasNextLine()){
        String currentLine = br.nextLine();
        match = ex.matcher(currentLine);
        if (match.find()) {
          pokemon.put(match.group(1), match.group(2));
        }
      }
      br.close();
    }
    catch (FileNotFoundException fnf) {
      System.out.println("Something went wrong: File not found");
    }  
  } 

  public static PokemonGenerator getInstance(){
    if (instance == null){
      instance = new PokemonGenerator();
    } 
    return instance;
  }

  public Pokemon generateRandomPokemon(int level) {
    Random rand = new Random(); 
    int randPoke = rand.nextInt(pokemon.size());
    String[] newPokeName = pokemon.keySet().toArray(new String[pokemon.size()]);
    String getNewPoke = newPokeName[randPoke];
    Pokemon pokeGen = getPokemon(getNewPoke);
    for (int i = 1; i < level; i++) {
      pokeGen = addRandomBuff(pokeGen);
    }
    return pokeGen; 
  } 

  public Pokemon getPokemon(String name) {
    Pokemon getPoke = null;
    String type = pokemon.get(name);
    Random rand = new Random();
    int randHealth = rand.nextInt(25 - 20) + 20;
    if (type.equals("Grass")){
      getPoke = new Grass(name, randHealth , randHealth);
    } else if (type.equals("Water")){
      getPoke = new Water(name, randHealth, randHealth);
    } else if (type.equals("Fire")){
     getPoke = new Fire(name, randHealth, randHealth);
    }
    return getPoke;
  }

  public Pokemon addRandomBuff(Pokemon p) {
    Random rand = new Random();
    int randBuff = rand.nextInt(2); 
    if (randBuff == 0){
      p = new AttackUp(p);
    } else{
      p = new HpUp(p);
    }
    return p;
  }

  public Pokemon addRandomDebuff(Pokemon p){
    Random rand = new Random();
    int randDebuff = rand.nextInt(2); 
    if (randDebuff == 0){
      p = new AttackDown(p);
    } else{
      p = new HpDown(p);
    }
    return p;
  }
} 