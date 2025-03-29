/*
 * This class is used for certain set operations learned in class like set union, intersection, and complement of a set
 * 
 * @author Juan Villaman
 */
import java.util.ArrayList;

public class SetOperations {
  
  /*
   * This method gets the union between two sets
   * 
   * @param ArrayList<String> setA - the first set used in the union
   * @param ArrayList<String> setB - the second set used in the union
   * @return ArrayList<String> setUnion - this returns the arraylist containing the union between set A and B.
   */
  public ArrayList<String> setUnion(ArrayList<String> setA, ArrayList<String> setB){
    ArrayList<String> setUnion = new ArrayList<>();

    setUnion.addAll(setA);
    setUnion.addAll(setB);
    
    for(int i = 0; i < setUnion.size(); i++){
      for(int j = i + 1; j < setUnion.size(); j++){
        if(setUnion.get(i).equals(setUnion.get(j))){
          setUnion.remove(j);
          j--;
        }
      }
    }
    return setUnion;
  }

  /*
   * This method gets the set intersection between two sets
   * 
   * @param ArrayList<String> setA - the first set used in the intersection
   * @param ArrayList<String> setB - the second set used in the intersection
   * @return ArrayList<String> setIntersection - this returns the arraylist containing the intersection between set A and B.
   */
  public ArrayList<String> setIntersection(ArrayList<String> setA, ArrayList<String> setB){
    ArrayList<String> setIntersection = new ArrayList<>();

    for(int i = 0; i < setA.size(); i++){
      for(int j = 0; j < setB.size(); j++){
        if(setA.get(i).equals(setB.get(j)) && !setIntersection.contains(setB.get(j))){
          setIntersection.add(setB.get(j));
        }
      }
    }
    return setIntersection;
  }

  /*
   * This method returns the complement between a set and a subset
   * 
   * @param ArrayList<String> setA - the set being used for the complement
   * @param ArrayList<String> subSet - the other set being compared to setA in order to get the complement
   * @return ArrayList<String> complementArray - this is the complement set of setA.
   */
  public ArrayList<String> complement(ArrayList<String> setA, ArrayList<String> subSet){
    ArrayList<String> complementArray = new ArrayList<>();
    for (String element : setA) {
      if(!subSet.contains(element)){
        complementArray.add(element);
      }
    }
    return complementArray;
  }
}
