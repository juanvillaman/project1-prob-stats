/*
 * This interface ensures that each Pokemon has two attacks, and can write their own two attacks in their respective classes
 * 
 * @author Juan Villaman
 */
public interface Attackable {
  boolean attackOne(Pokemon pokemon);
  boolean attackTwo(Pokemon pokemon);
}
