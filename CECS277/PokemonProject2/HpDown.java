import java.util.*;

public class HpDown extends PokemonDecorator {
  public HpDown(Pokemon p) {
    super(p, " -HP", p.getHp() - 1);
  }
}