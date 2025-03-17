/*
 * The Stadium class sets up the battlefield for both players, and holds the main game loop
 * 
 * @author Juan Villaman
 */
import java.util.Random;

public class Stadium {

  /*
   * Players that will participate in the game
   */
  Player player1 = new Player();
  Player player2 = new Player();

  /*
   * This constructor allows us to begin the gameplay in the main method, and also sets Player names for the game loop to work correctly
   */
  public Stadium(){
    player1.setName("Player 1");
    player2.setName("Player 2");
  }

  /*
   * This method handles the case in where a player has a mulligan, the other player gets to draw an extra card from their deck.
   */
  public void playerMulligan() {
    boolean player1Hand = player1.checkOpeningHand();
    boolean player2Hand = player2.checkOpeningHand();

    while (player1Hand == false || player2Hand == false) {
        if (player1Hand == false) {
            player2.drawExtraCard();
            player1.shuffle();
            player1Hand = player1.checkOpeningHand();
        }
        
        if (player2Hand == false) {
            player1.drawExtraCard();
            player2.shuffle();
            player2Hand = player2.checkOpeningHand();
        }
    }
}

  /*
   * This method simulates a coin toss to determine which player will go first
   *
   * @return true/false - true will make Player 1 go first, false will make player 2 go first.
   */
  public boolean coinToss(){
    Random rand = new Random();
    boolean result = rand.nextBoolean();

    System.out.println("A Coin will be tossed to determine which player goes first!");
    if(result){
      System.out.println("Player 1 will go first!");
      System.out.println();
    }else {
      System.out.println("Player 2 will go first!");
      System.out.println();
    }

    return result;
  }

  /*
   * This method handles the overall game loop, with turns going back and forth until a winner is declared
   */
  public void startGame(){
    System.out.println("Welcome to the Pokemon Trading Card Game!");
    System.out.println("Instructions on How to Win: ");
    System.out.println("1. Take all of your Prize Cards \n2. Knock Out all of your opponent's Pokemon in play \n3. If your opponent has no cards in their deck at the beginning of their turn");
    System.out.println();
    System.out.println("This is how the game board is set up: ");
    System.out.println("1. A coin will be flipped to determine turn order \n2. Each Player will draw 7 cards to their hands \n3. One basic Pokemon from the player's hand will be added to the Active field of the board, and the remaining Pokemon will be added to the player's bench. \n4. 6 prize cards will be randomly added to the prize pool from the player's deck. \n5. If a player does not have a basic Pokemon in their opening hand, the opposing player will draw an extra card to their hand from their deck, until both players have  at least one basic Pokemon in their hand.");
    System.out.println();
    System.out.println("This is what a player can do in a turn: ");
    System.out.println("1. Attach an Energy to the Active Pokemon \n2. Add a Pokemon to the bench from your hand \n3. Play a Trainer card \n4. You may retreat a Pokemon if your bench is not full \n5. Attack, which ends the player's turn");
    System.out.println();

    player1.playerOneSetUp();
    player2.playerTwoSetUp();

    playerMulligan();

    player1.setPlayerBoard();
    player2.setPlayerBoard();

    System.out.println();

    System.out.println("Player 1's Starting Board");
    player1.printPlayerBoard();

    System.out.println();

    System.out.println("Player 2's Starting Board");
    player2.printPlayerBoard();

    System.out.println();
    boolean firstTurn = coinToss();

    while(true){
      if(firstTurn){
        player1.playerTurn(player2);
        if(player1.winnerCheck(player2)){
          break;
        }
      } else{
          player2.playerTurn(player1);
          if(player2.winnerCheck(player1)){
            break;
          }
      }
      firstTurn = !firstTurn;
    }
  }
}



  // public void battle(Pokemon p1, Pokemon p2){

  //   //Temp Pokemons to store attack order
  //   Pokemon first = new Pokemon();
  //   Pokemon second = new Pokemon();

  //   //Determines the order of who attacks first
  //   if (p1.getSpeed() > p2.getSpeed()){
  //     first = p1;
  //     second = p2;
  //   } else if(p2.getSpeed() > p1.getSpeed()){
  //     first = p2;
  //     second = p1;
  //   }

  //   System.out.println("The Battle Begins!");

  //   while (p1.getHP() > 0 && p2.getHP() > 0){
  //     attack(first, second);
  //     if (second.getHP() <= 0){
  //       System.out.println(second.getName() + " has fainted!");
  //       break;
  //     }
  //     attack(second, first);
  //     if (first.getHP() <= 0){
  //       System.out.println(first.getName() + " has fainted!");
  //       break;
  //     }
  //   }
  //   }
  //   private void attack(Pokemon p1, Pokemon p2){
  //     int damage = (p1.getAttack() - p2.getDefense());
  //     p2.setHP(p2.getHP() - damage);
  //     System.out.println(p1.getName() + " has hit " + p2.getName() + " for " + damage + " damage!");
  //     System.out.println(p2.getName() + " has " + p2.getHP() + " HP left!");
  //     System.out.println();
  //   }
  



