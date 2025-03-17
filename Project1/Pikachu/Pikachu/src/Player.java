/*
 * This class hold all the methods that the Player will use in order to play the game, like attacking and attaching energy to a Pokemon
 * 
 * @author Juan Villaman
 */
import java.util.*;

public class Player {
  
  /*
   * Variable creation for a successful Pokemon TCG Board Game
   */
  private String playerName;
  private ArrayList<Card> deck;
  private ArrayList<Card> hand;
  private ArrayList<Card> prizePool;
  private ArrayList<Card> discard;
  private ArrayList<Card> active;
  private ArrayList<Card> bench;

  Scanner in = new Scanner(System.in);

  /*
   * This constructor initializes all the necessary variables needed to successfully play the Pokemon Trading Card Game
   */
  public Player(){
    deck = new ArrayList<Card>();
    hand = new ArrayList<Card>();
    prizePool = new ArrayList<Card>();
    discard = new ArrayList<Card>();
    active = new ArrayList<Card>();
    bench = new ArrayList<Card>();
  }

  /*
   * Method to set the name of the player
   */
  public void setName(String name){
    playerName = name;
  }

  /*
   * Method to get the name
   * 
   * @return playerName - gets the name of the player
   */
  public String getName(){
    return playerName;
  }

  /*
   * Method to get the deck
   * 
   * @return deck - gets the elements in the deck ArrayList
   */
  public ArrayList<Card> getDeck(){
    return deck;
  }

  /*
   * Method to get the bench
   * 
   * @return bench - gets the elements in the bench ArrayList
   */
  public ArrayList<Card> getBench(){
    return bench;
  }

  /*
   * Method to get the active field
   * 
   * @return active - gets the elements in the active field ArrayList
   */
  public ArrayList<Card> getActive(){
    return active;
  }

  /*
   * Method to get the discard pile
   * 
   * @return discard - gets the elements in the discard pile ArrayList
   */
  public ArrayList<Card> getDiscard(){
    return discard;
  }

  /*
   * Method to get the player's hand
   * 
   * @return hand - gets the elements in the hand ArrayList
   */
  public ArrayList<Card> getHand(){
    return hand;
  }

  /*
   * This method constructs the deck for Player 1
   * 10 Pikachu, 10 Charmander, 10 Fire, 10 Lightning, 7 Professor's Research, 7 Bill, 7 Jill
   */
  public void makeDeckOne(){
    for(int i = 0; i < 10; i++){
      deck.add(new Pikachu());
    }
    for(int i = 0; i < 10; i++){
      deck.add(new Charmander());
    }
    for(int i = 0; i < 10; i++){
      deck.add(new Fire());
    }
    for(int i = 0; i < 10; i++){
      deck.add(new Lightning());
    }
    for(int i = 0; i < 7; i++){
      deck.add(new ProfessorsResearch());
    }
    for(int i  = 0; i < 7; i++){
      deck.add(new Bill());
    }
    for(int i = 0; i < 6; i++){
      deck.add(new Jill());
    }
  }

  /*
   * This method constructs the deck for Player 2
   * 10 Pikachu, 10 Chikorita, 10 Grass, 10 Lightning, 7 Professor's Research, 7 Bill, 7 Jill
   */
  public void makeDeckTwo(){
    for(int i = 0; i < 10; i++){
      deck.add(new Pikachu());
    }
    for(int i = 0; i < 10; i++){
      deck.add(new Chikorita());
    }
    for(int i = 0; i < 10; i++){
      deck.add(new Grass());
    }
    for(int i = 0; i < 10; i++){
      deck.add(new Lightning());
    }
    for(int i = 0; i < 7; i++){
      deck.add(new ProfessorsResearch());
    }
    for(int i  = 0; i < 7; i++){
      deck.add(new Bill());
    }
    for(int i = 0; i < 6; i++){
      deck.add(new Jill());
    }
  }

  /*
   * Method to draw the top card of the prize pool after knocking out the opponent's Pokemon
   */
  public void drawPrizeCard(){
    if(!prizePool.isEmpty()){
      hand.add(prizePool.remove(0));
    }
    else{
      System.out.println("No more prize cards left!");
    }
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
   * This method populates the player's prize pool with 6 random cards from the deck
   */
  public void userPrizePool(){
    for(int i = 0; i < 6; i++){
      prizePool.add(drawCard());
    }
  }

  /*
   * This method moves the active field pokemon into the discard pile
   */
  public void activeToDiscard(Pokemon poke){
    discard.add(poke);
    active.remove(poke);
  }

  /*
   * This method prompts the user to add a Pokemon to the active field from their bench, called after their Pokemon has been knocked out
   */
  public void addToActiveField(){
    int userChoice;
    int count = 0;
    if(bench.isEmpty()){
      System.out.println("No Pokemon left on the bench to move to active.");
      return;
    }

    System.out.println(this.getName() + ", choose a Pokemon from your bench to become active: ");

    for(int i = 0; i < bench.size(); i++){
      count++;
      System.out.println((count) + ". " + bench.get(i).getName());
    }

    while (true){
      if(in.hasNextInt()){
        userChoice = in.nextInt();
        if(userChoice >= 1 && userChoice <= bench.size()){
          break;
        }
      }
      else {
        in.next();
      }
      System.out.println("No Pokemon was selected. Select a Valid Pokemon!");
    }

    Pokemon chosenPokemon = (Pokemon) bench.remove(userChoice - 1);
    active.add(chosenPokemon);
    System.out.println(chosenPokemon.getName() + " is your new active Pokemon!");
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
   * This method allows players to draw an extra card
   */
  public void drawExtraCard(){
    hand.add(drawCard());
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
   * This method checks the win conditions for the players
   * 
   * @return true/false - whichever win condition is met first by a player will return true, otherwise the game will continue
   */
  public boolean winnerCheck(Player player){
    if(prizePool.isEmpty()){
      System.out.println(this.getName() + " has defeated " + player.getName() + " by taking all Prize Cards!");
      return true;
    }

    if(player.active.isEmpty() && player.bench.isEmpty()){
      System.out.println(player.getName() + " has run out of Pokemons! " + this.getName() + " wins!");
      return true;
    }

    if(player.deck.isEmpty()){
      System.out.println(player.getName() + " has run out of cards! " + this.getName() + " wins!");
      return true;
    }
    
    System.out.println("Next Round!");
    System.out.println();
    return false;
    }

  /*
   * Adds a chosen pokemon to the active field from the Player's hand
   */
  public void activeFromHand(Pokemon poke){
    active.add(poke);
    hand.remove(poke);
  }

  /*
   * Adds a chosen pokemon to the bench from the Player's hand
   */
  public void pokemonToBench(Pokemon poke){
    bench.add(poke);
    hand.remove(poke);
  }

  /*
   * This method automatically sets up the game board for the Player
   */
  public void setPlayerBoard(){
    Card currCard = new Card();
    int benchMax = 5;
    int benchCount = 0;
    userPrizePool();

    for(int i = 0; i < hand.size(); i++){
      currCard = hand.get(i);
      if(currCard instanceof Pokemon){
        Pokemon chosenPoke = (Pokemon) currCard;
        activeFromHand(chosenPoke);
        break;
      }
    }

    for(int i = 0; i < hand.size(); i++){
      if(benchCount >= benchMax){
        break;
      }

      currCard = hand.get(i);
      if(currCard instanceof Pokemon){
        Pokemon chosenPoke = (Pokemon) currCard;
        pokemonToBench(chosenPoke);
        i--;
        benchCount++;
      }
    }
  }

  /*
   * This method allows for the player to attach an Energy card to their active Pokemon.
   */
  public void attachEnergy(){
    boolean energyInHand = false;
    int userChoice;
    Card currCard;

    for(Card card : hand){
      if(card instanceof Energy){
        energyInHand = true;
        break;
      }
    }

    if(!energyInHand){
      System.out.println("No Energy cards left in your hand!");
      return;
    }
    System.out.println("Pick an Energy Card to add to your Active Pokemon");
    System.out.println(printPlayerHand());

    while (true){
      System.out.println("Choose a Card (1, 2, 3, 4, 5): ");
      if(in.hasNextInt()){
        userChoice = in.nextInt();
        if(userChoice >= 1 && userChoice <= hand.size()){
          break;
        }
      }
      else {
        in.next();
      }
      System.out.println("Not a valid choice. Choose a number of 1 - 5");
    }

    Pokemon activePokemon = (Pokemon) active.get(0);
    currCard = hand.get(userChoice - 1);
    if(currCard instanceof Energy){
      Energy chosenEnergy = (Energy) currCard;
      hand.remove(userChoice - 1);
      activePokemon.attachEnergy(chosenEnergy.getName());
      System.out.println("You attached " + chosenEnergy.getName() + " Energy to " + activePokemon.getName());
      System.out.println();
    }
    else{
      System.out.println("This is not an energy card!");
    }
  }

  /*
   * This method allows the player to play a Trainer Card from their hand
   */
  public void playTrainerCard(){
    boolean trainerInHand = false;
    int userChoice;

    for(Card card : hand){
      if(card instanceof Trainer){
        trainerInHand = true;
        break;
      }
    }

    if(!trainerInHand){
      System.out.println("No Trainer cards left in your hand!");
      return;
    }

    System.out.println("Pick a Trainer Card to Play");
    System.out.println(printPlayerHand());

    while (true){
      System.out.println("Choose a Card (1, 2, 3, 4, 5): ");
      if(in.hasNextInt()){
        userChoice = in.nextInt();
        if(userChoice >= 1 && userChoice <= hand.size() && hand.get(userChoice - 1) instanceof Trainer){
          break;
        }
      }
      else {
        in.next();
      }
      System.out.println("Not a valid choice. Choose a number of 1 - 5");
    }

    Trainer chosenTrainerCard = (Trainer) hand.get(userChoice - 1);
    hand.remove(chosenTrainerCard);
    discard.add(chosenTrainerCard);

    chosenTrainerCard.play(this);
    System.out.println("This is your new hand: " + printPlayerHand());
    System.out.println();
  }

  /*
   * This method allows a player to add a Pokemon card to their bench from their hand if the bench is not full
   */
  public void addToBench(){
    boolean pokeInHand = false;
    int userChoice;

    if (bench.size() >= 5) {
      System.out.println("Your bench is full! You cannot add more Pokémon.");
      return;
  }
    for(Card card : hand){
      if(card instanceof Pokemon){
        pokeInHand = true;
        break;
      }
    }

    if(!pokeInHand){
      System.out.println("No Pokemon cards left in your hand!");
      return;
    }

    System.out.println("Pick a Pokemon Card to add to your bench");
    System.out.println(printPlayerHand());

    while (true){
      System.out.println("Choose a Card: ");
      if(in.hasNextInt()){
        userChoice = in.nextInt();
        if(userChoice >= 1 && userChoice <= hand.size() && hand.get(userChoice - 1) instanceof Pokemon){
          break;
        }
      }
      else {
        in.next();
      }
      System.out.println("Not a valid choice. Choose a number a Pokemon");
    }

    Pokemon chosenPokemon = (Pokemon) hand.get(userChoice - 1);
    pokemonToBench(chosenPokemon);
  }

  /*
   * This method adds the card names in hand to an ArrayList of Strings to print out for easy readibility.
   * 
   * @return handCards - an ArrayList of strings consisting of the card names from the hand.
   */
  public ArrayList<String> printPlayerHand(){
    ArrayList<String> handCards = new ArrayList<>();
    for(Card card : hand){
      handCards.add(card.getName());
    }
    return handCards;
  }
  
  /*
   * This method adds the card names in bench to an ArrayList of Strings to print out for easy readibility.
   * 
   * @return benchCards - an ArrayList of strings consisting of the card names from the bench.
   */
  public ArrayList<String> printPlayerBench(){
    ArrayList<String> benchCards = new ArrayList<>();
    for(Card card : bench){
      benchCards.add(card.getName());
    }
    return benchCards;
  }

  /*
   * This method sets Player 1's deck and populating their hands with 7 cards
   */
  public void playerOneSetUp(){
    makeDeckOne();
    drawHand();
  }

  /*
   * This method sets Player 2's deck and populating their hands with 7 cards
   */
  public void playerTwoSetUp(){
    makeDeckTwo();
    drawHand();
  }

  /*
   * This method displays the player's board
   */
  public void printPlayerBoard(){
    System.out.println(this.getName());
    System.out.println("Your hand: " + printPlayerHand());

    Pokemon activePoke = (Pokemon) active.get(0);
    System.out.println("Your Active Pokemon: " + activePoke.getName());

    System.out.println("Your Bench: " + printPlayerBench());
    System.out.println("Amount of Cards left in your deck: " + deck.size());
    System.out.println("Amount of Prize Cards remaning: " + prizePool.size());
  }

  /*
   * This method allows the player to retreat their active Pokemon to their bench as long as the bench is not full with other Pokemon
   */
  public void retreatPokemon(){
    if(bench.size() >= 5){
      System.out.println("Can't retreat active Pokemon since your bench is full!");
      return;
    }
    System.out.println("Select a Pokemon from the bench to become active: " + printPlayerBench());

    while(true){
      if(!in.hasNextInt()){
        System.out.println("Invalid number. Enter a number corresponding to the position of the Pokemon in your bench");
        in.next();
      }else{
        int userChoice = in.nextInt();

        if(userChoice >= 1 && userChoice <= bench.size()){
          Card chosenPoke = bench.get(userChoice - 1);

          if(chosenPoke instanceof Pokemon){
            bench.add(active.remove(0));
            active.add((Pokemon) chosenPoke);
            bench.remove(userChoice - 1);

            System.out.println("Pokemon has been retreated!");
            break;
          }else{
            System.out.println("Select a Pokemon please!");
          }
        }else{
          System.out.println("Make sure a number corresponding the position of the Pokemon is chosen!");
        }
      }
    }

  }
  
  /*
   * This method checks if any both of the player's active Pokemon has been knocked out. If the opponent is knocked out, the player will draw a Prize Card
   */
  public void knockedOut(Player player1){
    Pokemon opponent = (Pokemon) player1.active.get(0);

    if(opponent.getHP() <= 0){
      this.drawPrizeCard();
      player1.activeToDiscard(opponent);
      if(player1.bench.size()>0){
        player1.addToActiveField();
      }
    }
  }

  /*
   * This method allows the player to attack the opponent's active Pokemon
   */
  public boolean attack(Player target){
    Pokemon attacker = (Pokemon) active.get(0);
    Pokemon opponent = (Pokemon) target.active.get(0);
    int userChoice;
    boolean attackSuccessful = false;

    System.out.println("Pick an attack using numbers: \n1: " + attacker.getAttackOne() + "\n2: " + attacker.getAttackTwo() + "\n3: No attack");

    while(true){
      if(!in.hasNextInt()){
        System.out.println("Invalid Input. Try again!");
        in.next();
        continue;
      }

      userChoice = in.nextInt();
      if(userChoice < 1 || userChoice > 3){
        System.out.println("Invalid Input, Try again!");
      }else{
        break;
      }
    }
    switch(userChoice) {
      case 1:
        attackSuccessful = attacker.attackOne(opponent);
        System.out.println(target.getName() + "'s " + opponent.getName() + " has been hit by " + attacker.getAttackOne() + "!");
        break;
      case 2:
        attackSuccessful = attacker.attackTwo(opponent);
        System.out.println(target.getName() + "'s " + opponent.getName() + " has been hit by " + attacker.getAttackTwo() + "!");
        break;
      case 3:
        System.out.println("No attack was selected");
        return true;
    }

    if(attackSuccessful){
      System.out.println(target.getName() + "'s " + opponent.getName() + " now has "  + opponent.getHP() + " HP.");
      System.out.println();
      knockedOut(target);
      return true;
    }else{
      return false;
    }
  }

  /*
   * This method gives the players the choices they can make when it is their turn, and the turn will end once the player attacks
   */
  public void playerTurn(Player target){
    int userMove;
    boolean turnOverCheck = false;
    hand.add(drawCard());
    while(!turnOverCheck){
      this.printPlayerBoard();
      System.out.println("Reminder! Once you attack, your turn is over. \n(1) You may attach energy \n(2) add a Pokemon to the bench \n(3) play a trainer card \n(4) retreat your active pokemon \n(5) Attack!");
      userMove = in.nextInt();
      switch(userMove){
        case 1:
          attachEnergy();
          break;

        case 2:
          addToBench();
          break;

        case 3:
          playTrainerCard();
          break;

        case 4:
          retreatPokemon();
          break;

        case 5:
          turnOverCheck = attack(target);
          break;

        default:
          System.out.println("Invalid Choice. Choose a number between 1-5");
      }
    }
  }
}
