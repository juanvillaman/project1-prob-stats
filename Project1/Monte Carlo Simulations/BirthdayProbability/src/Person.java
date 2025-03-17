/*
 * This class creates the People with random birthdays in order to run our Monte Carlo Simulation
 * 
 * @author Juan Villaman
 */
import java.util.Random;
import java.util.ArrayList;

public class Person {
  
  private int month;
  private int day;

  Random rand = new Random();

  /*
   * This is a constructor for Person that are generated with random birthdays
   */
  public Person(){
    generateBirthdays();
  }

  /*
   * This method handles the random birthday generation, taking into account the months that have different days to avoid i.e. February 30th
   */
  public void generateBirthdays(){
    month = rand.nextInt(12) + 1;

    if (month == 2){
      day = rand.nextInt(28) + 1;
    }
    else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
      day = rand.nextInt(31) + 1;
    }
    else {
      day = rand.nextInt(30) + 1;
    }
  }

  /*
   * This method gets the month from the Person's birthday
   * 
   * @return month - the month of date
   */
  public int getMonth(){
    return month;
  }

  /*
   * This method gets the day from the Person's birthday
   * 
   * @return day - the day of date
   */
  public int getDay(){
    return day;
  }

  /*
   * This method determines whether there people with the same birthday within a set of people created
   * 
   * @param int personCount - this determines the amount of people created with random birthdays
   * @return true/false - if there are 2 people in the set with the same birthday, it'll return true, otherwise false
   */
  public static boolean containsSharedBirthday(int personCount){
    ArrayList<String> birthdays = new ArrayList<String>();

    for(int i = 0; i < personCount; i++){
      Person person = new Person();
      String birthday = person.getMonth() + "/" + person.getDay();

      if (birthdays.contains(birthday)){
        return true;
      }

      birthdays.add(birthday);
    }
    return false;
  }

  /*
   * This method runs our Monte Carlo simulation, calculating the probability of a number of people having the same birthday
   * 
   * @param int personCount - this determines the amount of people created
   * @return the results of our simulation (successes / total trials)
   */
  public double calculateBirthdayProbability(int personCount, int simulationAmount){
    int count = 0;

    for (int i = 0; i < simulationAmount; i++){
      if(containsSharedBirthday(personCount)){
        count++;
      }
    }
    
    return (double) count / simulationAmount * 100;
  }
  
}
