/*
 * Parent class for the Pokemon. All Pokemon Cards are created off this class\
 * 
 * @author Juan Villaman
 */
public class Pokemon extends Card implements Attackable{

  /*
   * Variables needed for Pokemon creation
   */
  private int hp;
  private int attachedEnergy;
  private int matchingEnergy;
  private String name;
  private String type;
  private String attackOne;
  private String attackTwo;
  
  /*
   * Gets the Pokemon's HP
   * 
   * @return hp - Pokemon's current HP
   */
  public int getHP(){
    return hp;
  }

  /*
   * Gets the Pokemon's Name
   * 
   * @return name - Pokemon's Name
   */
  public String getName(){
    return name;
  }

  /*
   * Gets the name of Attack One
   * 
   * @return attackOne - Name of the Pokemon's Attack One
   */
  public String getAttackOne(){
    return attackOne;
  }

  /*
   * Gets the name of Attack Two
   * 
   * @return attackTwo - Name of the Pokemon's Attack Two
   */
  public String getAttackTwo(){
    return attackTwo;
  }

  /*
   * Sets the Elemental type for the Pokemon
   */
  public void pokemonType(String type){
    this.type = type;
  }

  /*
   * Gets the attached energy of the Pokemon
   * 
   * @return attachedEnergy - the amount of energy attached to the pokemon
   */
  public int getAttachedEnergy(){
    return attachedEnergy;
  }

  /*
   * Gets the matching energy of the Pokemon
   * 
   * @return matchingEnergy - the amount of matching energy attached to the pokemon
   */
  public int getMatchingEnergy(){
    return matchingEnergy;
  }

  /*
   * This method is implemented from the Attackable interface to pass down to Pokemon, allowing an attack to be specific for that specific Pokemon
   * 
   * @return false - In case the pokemon has no attacks, it'll return false
   */
  @Override
  public boolean attackOne(Pokemon pokemon){
    return false;
  }

  /*
   * This method is implemented from the Attackable interface to pass down to Pokemon, allowing an attack to be specific for that specific Pokemon
   * 
   * @return false - In case the pokemon has no attacks, it'll return false
   */
  @Override
  public boolean attackTwo(Pokemon pokemon){
    return false;
  }

  /*
   * Sets the HP of the Pokemon
   * 
   * @param userHP - the HP the Pokemon will have
   */
  public void setHP(int userHP){
    hp = userHP;
  }

  /*
   * Sets the name of the Pokemon
   * 
   * @param pokeName - the name the Pokemon will have
   */
  public void setName(String pokeName){
    name = pokeName;
  }

  /*
   * Sets the name for attack one of the Pokemon
   * 
   * @param attackOne - the name of attack one
   */
  public void setAttackOne(String attackOne){
    this.attackOne = attackOne;
  }

  /*
   * Sets the name for attack two of the Pokemon
   * 
   * @param attackTwo - the name of attack two
   */
  public void setAttackTwo(String attackTwo){
    this.attackTwo = attackTwo;
  }

  /*
   * This method is called when an Energy card is attached to a Pokemon
   * 
   * @param energy - this is the energy card being attached. If it matches with the Pokemon's type, matchingEnergy increases, allowing for attackTwo to be played
   */
  public void attachEnergy(String energy){
    attachedEnergy++;
    if(type.equals(energy)){
      matchingEnergy++;
    }
  }
}


