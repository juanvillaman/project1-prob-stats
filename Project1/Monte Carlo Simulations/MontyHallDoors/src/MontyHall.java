/*
 * This class handles the Monty Hall game, as well having the program pick a door to see its chances of being correct
 * 
 * @author Juan Villaman
 */
import java.util.Random;

public class MontyHall {

  /*
   * Constructor to be able to run the simulation in our Main method
   */
  public MontyHall(){
  }

  private static int numOfDoor = 3;

  /*
   * This method handles the Monte Carlo Simulation, having the program pick a random door and keeping track of its correct guesses
   */
  public void montyHallMonteCarlo() {
    Random rand = new Random();
    int correctGuesses = 0;

    for (int i = 0; i < 10000; i++) {
      int prizeDoor = rand.nextInt(numOfDoor); // Randomly place the prize
      int chosenDoor = rand.nextInt(numOfDoor); // Randomly pick a door

      if (chosenDoor == prizeDoor) {
        correctGuesses++;
      }
    }
    double probability = (double) correctGuesses / 10000 * 100;
    System.out.println("Probability of choosing the correct door: " + probability + "%");
  }
}
