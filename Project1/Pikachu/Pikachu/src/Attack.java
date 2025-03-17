/* 
 * This class contains the method that gives Pokemon their ability to attack depending on the amount of Energy cards attached.
 * Another purpose for this class is to avoid having to write this helper method in each individual Pokemon class
 * 
 * @author Juan Villaman
 */

public class Attack {

  /*
   * This method checks for the energies attached to the active Pokemon, and allows the user to perform the attack given that they meet the energy requirement
   * 
   * @param Pokemon attacker - this the Player's active pokemon when attacking
   * @param Pokemon opponent - this is the Player's opponent active pokemon
   * @param int energyRequired - this is the amount of energy required to perform an attack
   * @param int requiredMatchingEnergy - this is the amount of matching energy the pokemon needs to perform an attack
   * @param int damage - this is the damage done by the attack, used to calculate HP
   * @return true/false - this determines if the Pokemon has enough energy to perform the attack. If not, the Player will need to attach more energy cards
   */
  public static boolean performAttack(Pokemon attacker, Pokemon opponent, int energyRequired, int requiredMatchingEnergy, int damage){
    if(attacker.getAttachedEnergy() >= energyRequired && attacker.getMatchingEnergy() >= requiredMatchingEnergy){
      int resultHP = opponent.getHP() - damage;
      opponent.setHP(resultHP);
      return true;
    }else {
      System.out.println("Not enough energy to perform the attack! Attach More Energy!");
      System.out.println();
      return false;
    }
  }
}
