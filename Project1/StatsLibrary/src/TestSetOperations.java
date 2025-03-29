/*
 * This class is a tester for Set Operations, showcasing the different operations that can be used on sets containing elements
 * 
 * @author Juan Villaman
 */
import java.util.ArrayList;
import java.util.Arrays;

public class TestSetOperations {
  
  public static void main(String[] args){

    SetOperations test = new SetOperations();
    System.out.println("Welcome to my SetOperations Program. By using days of a week, we can demonstrate the operations!");

    ArrayList<String> setA = new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));
    ArrayList<String> setB = new ArrayList<>(Arrays.asList("Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));

    ArrayList<String> unionResult = test.setUnion(setA, setB);
    ArrayList<String> intersectionResult = test.setIntersection(setA, setB);
    ArrayList<String> complementAtoB = test.complement(setA, setB);
    ArrayList<String> complementBtoA = test.complement(setB, setA);

    System.out.println("Union: " + unionResult);
    System.out.println("Intersection: " + intersectionResult);
    System.out.println("Complement (setA - setB): " + complementAtoB);
    System.out.println("Complement (setB - setA): " + complementBtoA);
    }
}