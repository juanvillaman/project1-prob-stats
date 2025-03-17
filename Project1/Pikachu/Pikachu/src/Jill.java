/*
 * This class is for the Jill Trainer card containing its Trainer ability, and applies it to the Player that used the card
 * 
 * @author Juan Villaman
 */
import java.util.ArrayList;

public class Jill extends Trainer {

  /*
   * Constructor for the Jill Trainer Card
   */
  public Jill(){
    setName("Jill");
  }

  /*
   * Jill's ability: Draw 3 extra cards to your hand
   * 
   * @param Player player - this is the player who is playing the Jill Trainer Card
   */
  public void play(Player player){
    System.out.println("Draw 3 extra cards");
    ArrayList<Card> hand = player.getHand();

    if(player.getDeck().isEmpty()){
      System.out.println("No cards left in your deck! Trainer Card Jill cannot be played!");
      return;
    }

    for(int i = 0; i < 4; i++){
      Card card = player.drawCard();
      hand.add(card);
    }
  }
  
}
