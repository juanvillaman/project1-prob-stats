/*
 * This class creates Professor's Research Trainer Card
 * 
 * @author Juan Villaman
 */
import java.util.ArrayList;

public class ProfessorsResearch extends Trainer{

  /*
   * Constructor for the Trainer Card Professor's Research
   */
  public ProfessorsResearch(){

    setName("Professor's Research");
  }

  /*
   * This is Professor's Research ability: Discard your hand and draw 7 cards from your deck
   * 
   * @param Player player - this is the player who is playing the Professor's Research card
   */
  public void play(Player player){

    System.out.println("Professor's Research: Discard your hand and draw 7 cards");
    ArrayList<Card> discard = player.getDiscard();
    ArrayList<Card> hand = player.getHand();

    for(Card card : hand){
      discard.add(card);
    }
    hand.clear();

    for(int i = 0; i < 7; i++){
      hand.add(player.drawCard());
    }
  }
}
