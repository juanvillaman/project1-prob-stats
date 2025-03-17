/*
 * This class creates the Charmander Pokemon card to be used during the game
 * 
 * @author Juan Villaman
 */
public class Charmander extends Pokemon{

  /*
   * Variables to store attack damage values
   */
  private static final int SCRATCH = 10;
  private static final int EMBER = 20;

  /*
   * This creates the Charmander Pokemon Card with attributes from the Pokemon class
   */
  public Charmander(){
    setHP(60);
    setName("Charmander");
    pokemonType("Fire");
    setAttackOne("Scratch");
    setAttackTwo("Ember");
  }

  /*
   * This method allows for Charmander to attack the opposing player's Active Pokemon using SCRATCH
   * 
   * @param Pokemon opponent - this is the opposing player's Active Pokemon
   */
  @Override
  public boolean attackOne(Pokemon opponent){
    boolean attack = Attack.performAttack(this, opponent, 1, 0, SCRATCH);
    return attack;
  }

  /*
   * This method allows for Charmander to attack the opposing player's Active Pokemon using EMBER
   * 
   * @param Pokemon opponent - this is the opposing player's Active Pokemon
   */
  @Override
  public boolean attackTwo(Pokemon opponent){
    boolean attack = Attack.performAttack(this, opponent, 2, 1, EMBER);
    return attack;
  }

}
