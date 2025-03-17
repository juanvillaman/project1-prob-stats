/*
 * This class creates the Chikorita Pokemon card to be used during the game
 * 
 * @author Juan Villaman
 */
public class Chikorita extends Pokemon{

  /*
   * Variables to store attack damage values
   */
  private static final int TACKLE = 10;
  private static final int RECKLESS_CHARGE = 20;

  /*
   * This creates the Chikorita Pokemon Card with attributes from the Pokemon class
   */
  public Chikorita(){
    setHP(50);
    setName("Chikorita");
    pokemonType("Grass");
    setAttackOne("Tackle");
    setAttackTwo("Reckless Charge");
  }

  /*
   * This method allows for Chikorita to attack the opposing player's Active Pokemon using TACKLE
   * 
   * @param Pokemon opponent - this is the opposing player's Active Pokemon
   */
  @Override
  public boolean attackOne(Pokemon opponent){
    boolean attack = Attack.performAttack(this, opponent, 1, 0, TACKLE);
    return attack;
  }

  /*
   * This method allows for Chikorita to attack the opposing player's Active Pokemon using RECKLESS CHARGE
   * 
   * @param Pokemon opponent - this is the opposing player's Active Pokemon
   */
  @Override
  public boolean attackTwo(Pokemon opponent){
    boolean attack = Attack.performAttack(this, opponent, 2, 1, RECKLESS_CHARGE);
    return attack;
  }

}

