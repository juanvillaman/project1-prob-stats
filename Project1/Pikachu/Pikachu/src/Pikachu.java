/*
 * This class creates the Pikachu Pokemon card to be used during the game
 * 
 * @author Juan Villaman
 */
public class Pikachu extends Pokemon{

  /*
   * Variables to store attack damage values
   */
  private static final int QUICK_ATTACK = 10;
  private static final int ELECTRO_BALL = 20;

  /*
   * This creates the Pikachu Pokemon Card with attributes from the Pokemon class
   */
  public Pikachu(){
    setHP(55);
    setName("Pikachu");
    pokemonType("Lightning");
    setAttackOne("Quick Attack");
    setAttackTwo("Electro Ball");
  }

  /*
   * This method allows for Pikachu to attack the opposing player's Active Pokemon using QUICK ATTACK
   * 
   * @param Pokemon opponent - this is the opposing player's Active Pokemon
   */
  @Override
  public boolean attackOne(Pokemon opponent){
    boolean attack = Attack.performAttack(this, opponent, 1, 0, QUICK_ATTACK);
    return attack;
  }

  /*
   * This method allows for Pikachu to attack the opposing player's Active Pokemon using ELECTRO BALL
   * 
   * @param Pokemon opponent - this is the opposing player's Active Pokemon
   */
  @Override
  public boolean attackTwo(Pokemon opponent){
    boolean attack = Attack.performAttack(this, opponent, 3, 1, ELECTRO_BALL);
    return attack;
  }

}