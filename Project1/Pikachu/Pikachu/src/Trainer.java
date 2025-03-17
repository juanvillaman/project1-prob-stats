/*
 * Parent class of Trainer Cards. It allows for standardized Trainer variations to be created
 * 
 * @author Juan Villaman
 */
public class Trainer extends Card implements TrainerEffect{
  
  private String name;

  /*
   * Sets the name of the Trainer card
   * 
   * @param cardName - the name of the Trainer card we are assigning it
   */
  public void setName(String cardName){
    name = cardName;
  }

  /*
   * Gets the name of the Trainer Card
   * 
   * @return name - the name of the Trainer Card
   */
  public String getName(){
    return name;
  }

  /*
   * Inherited method from the TrainerEffect Interface, allowing for Trainer cards to have their abilities in their own class
   */
  public void play(Player player){
    return;
  }
}
