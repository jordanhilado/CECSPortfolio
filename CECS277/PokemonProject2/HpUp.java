import java.util.*;

public class HpUp extends PokemonDecorator {
  public HpUp(Pokemon p) {
    super(p, " +HP", p.getHp() + 1);
  }
}