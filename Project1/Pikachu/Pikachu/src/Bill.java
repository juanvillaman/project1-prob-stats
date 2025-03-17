/*
 * This class is for the Bill Trainer card containing its Trainer ability, and applies it to the Player that used the card
 * 
 * @author Juan Villaman
 */
import java.util.ArrayList;

public class Bill extends Trainer {

  /*
   * Constructor for the Bill Trainer Card
   */
  public Bill(){
    setName("Bill");
  }

  /*
   * Bill's ability: Draw 2 extra cards to your hand
   * 
   * @param Player player - this is the player who is playing the Bill Trainer Card
   */
  public void play(Player player){
    System.out.println("Draw 2 extra cards");
    ArrayList<Card> hand = player.getHand();

    if(player.getDeck().isEmpty()){
      System.out.println("No cards left in your deck! Trainer Card Bill cannot be played!");
      return;
    }

    for(int i = 0; i < 3; i++){
      Card card = player.drawCard();
      hand.add(card);
    }
  }
  
}
