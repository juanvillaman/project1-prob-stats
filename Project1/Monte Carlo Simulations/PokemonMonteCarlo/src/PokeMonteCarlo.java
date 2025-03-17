/*
 * This class handles the logic for our different Monte Carlo Simulations, which are Mulligans, and Rare Candies in a deck
 * 
 * @author Juan Villaman
 */
import java.util.ArrayList;
import java.util.Random;

public class PokeMonteCarlo {

  private ArrayList<Card> deck; 
	private ArrayList<Card> hand;
	private ArrayList<Card> prizePool;
	private int deckSize = 60;
	private int insidePrizePool;

  /*
   * Initializes the variables needed for the Mulligan Monte Carlo Simulation
   */
  public PokeMonteCarlo() {
    deck = new ArrayList<>();
    hand = new ArrayList<>();
    prizePool = new ArrayList<>();
}

  /*
   * Method draws a random card from the deck of the player
   * 
   * return drawnCard - this is the random card that the player drew from the deck
   */
  public Card drawCard(){
    Random rand = new Random();
    int index = rand.nextInt(deck.size());
    Card drawnCard = deck.get(index);
    deck.remove(index);
    return drawnCard;
  }

  /*
   * This method populates the player's hand with 7 cards, the starting amount
   */
  public void drawHand(){
    for (int i = 0; i < 7; i++){
      hand.add(drawCard());
    }
  }

  /*
   * This method constructs a basic deck of 60 cards of just Pokemon and Energy cards
   * 
   * @param int numOfPokemon - this is the number of Pokemon that will be added to the deck
   */
  public void constructDeck(int numOfPokemon){
		deck.clear();
		hand.clear();
		for(int i = 0; i < numOfPokemon; i++ ) {
			deck.add(new Pokemon());
		}
		for(int j = numOfPokemon; j < deckSize; j++ ){
			deck.add(new Energy());
		}
	}

  /*
   * This method checks to see if the player has a Basic Pokemon in their opening hand
   * 
   * @return true/false - if Pokemon is in opening hand, true, otherwise false.
   */
  public boolean checkOpeningHand(){
    for (Card card : hand){
      if (card instanceof Pokemon){
        return true;
      }
    }
    return false;
  }

  /*
   * This method handles the Mulligan Monte Carlo Simulation. It calculates the percentage of a mulligan depending on the amount of Pokemon in your deck
   */
  public void mulliganMonteCarlo() {
    for (int numOfPokemon = 1; numOfPokemon <= deckSize; numOfPokemon++) {
      int mulliganCount = 0;

      for (int i = 0; i < 10000; i++) {
          constructDeck(numOfPokemon);
          drawHand();

          if (!checkOpeningHand()) {
              mulliganCount++;
          }
        }
        double mulliganRate = (double) mulliganCount / 10000 * 100;
        System.out.printf("Pokémon Count: %2d, Mulligan Rate: %.2f%%%n", numOfPokemon, mulliganRate);
    }
  }

  /*
   * This method clears the player's hands and puts them back into the deck, drawing another 7 random cards after using the drawHand method.
   */
  public void shuffle(){
    deck.addAll(hand);
    hand.clear();
    drawHand();
  }


  /*
   * This method checks if there is a Rare Candy card within the deck
   * 
   * @return true/false - if a deck contains a Rare Candy card, it will be true, otherwise false
   */
  public boolean rareCandyCheck(){
    for (Card card : deck) {
      if (card instanceof RareCandy) {
        return true;
      }
    }
    return false;
  }

  /*
   * This method checks if there are any Rare Candy within our Prize Pool
   * 
   * @return true/false - If there is a Rare Candy within the prize pool, it will be true, otherwise false
   */
  public boolean prizePoolRareCandy(){
    insidePrizePool = 0;

    for (Card card : prizePool) {
        if (card instanceof RareCandy) {
            insidePrizePool++;
        }
    }

    return insidePrizePool > 0;
  }

  /**
	 * This method clears the Prize Poll of cards 
	 */
	public void resetPrize() {
		prizePool.clear();
	}

  /*
   * This method draws a hand for the player, with at least one Pokemon in it to avoid mulligans
   */
  public void drawHandTwo() {
		for (int i = 0; i < 6; i++) {
			hand.add(drawCard());
		}
		hand.add(new Pokemon());
	}

  /*
   * This method populates the player's prize pool with 6 random cards from the deck
   */
  public void userPrizePool(){
    for(int i = 0; i < 6; i++){
      prizePool.add(drawCard());
    }
  }

  /*
   * This method checks if the deck or hand is bricked (No Rare Candies in either)
   * 
   * @return true/false - If there is a Rare Candy within the deck or hand, it will be true, otherwise false
   */
  public boolean checkBricked() {
    return !(rareCandyCheck() || prizePoolRareCandy());
  }

  /*
   * This method makes the Charizard Deck needed, filling the deck with Pokemon, Rare Candy, and filling the rest with Energy cards
   * 
   * @param int numOfPokemon - the number of Pokemon that will fill the deck
   * @param int numOfRareCandy - the number of Rare Candy cards that will the deck
   */
  public void constructCharizardDeck(int numOfPokemon, int numOfRareCandy) {
    deck.clear();
    hand.clear();
    prizePool.clear();
   
    for (int i = 0; i < numOfPokemon; i++) {
        deck.add(new Pokemon());
    }
    for (int i = 0; i < numOfRareCandy; i++) {
        deck.add(new RareCandy());
    }
    while (deck.size() < deckSize) {
        deck.add(new Energy());
    }
  }
  
  /*
   * This method runs our Rare Candy Monte Carlo Simulation, and will determine whether a deck is bricked (no Rare Candies in hand or deck)
   */
  public void charizardMonteCarlo() {
    for (int numRareCandy = 1; numRareCandy <= 4; numRareCandy++) {
      int bricked = 0;
      int notBricked = 0;

      for (int i = 0; i < 100000; i++) {
        constructCharizardDeck(10, numRareCandy);
        drawHandTwo();
        userPrizePool();

        if (checkOpeningHand()) {
          if (checkBricked()) {
            bricked++;
          } else {
              notBricked++;
            }
            } else {
              shuffle();
            }
        }
      double probabilityOfBrick = (double) bricked / (bricked + notBricked) * 100;
      System.out.printf("Rare Candy Count: %d, Bricked Probability: %.4f%%%n", numRareCandy, probabilityOfBrick);
    }
  }
}


