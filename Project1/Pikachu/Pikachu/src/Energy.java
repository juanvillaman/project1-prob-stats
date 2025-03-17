/*
 * This class is the parent class of Energy cards. Allows for the creation of Energy cards
 * 
 * @author Juan Villaman
 */
public class Energy extends Card{
 
  private String type;

  /*
   * Sets the type (element) of the Energy card
   * 
   * @param energyType - The type the energy card will be assigned
   */
  public void setType(String energyType){
    type = energyType;
  }

  /*
   * This method gets the name of the Energy card
   * 
   * @return type - name of the Energy card
   */
  public String getName(){
    return type;
  }
}
