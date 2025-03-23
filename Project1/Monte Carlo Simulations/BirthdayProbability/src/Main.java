/*
 * This is the tester class for the Birthday Probability Monte Carlo Simulation. You are able to adjust the amount of people created, and the amount of simulations
 * 
 * @author Juan Villaman
 */
public class Main {
  public static void main(String[] args) throws Exception {

      /*
       * Created a test Person object to run the simulation
       */
      Person run = new Person();

      System.out.println("Simulation results: " + run.calculateBirthdayProbability(33, 10000) + "%");
  }
}