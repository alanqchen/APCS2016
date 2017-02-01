/**
 * Alan Chen - APCompSci 2017
 * Project: Linked Lists
 * Date started: 2/1/2017
 * BONUS: 
 * TODO: 
 */
import java.util.*;
public class FamilyMap {
  private static Scanner input = new Scanner(System.in); 
  private Map<String,TreeSet<String>> fm;
  public FamilyMap() {
    fm = new TreeMap<String,TreeSet<String>>();
  }
  public void addFamily() {
    System.out.print("Please enter the last name: ");
    String last = input.next();
    String name = "filler";
    int count = 1;
    TreeSet<String> ns = new TreeSet<String>();
    while(!name.equals("")) {
      if (counter == 1) 
        System.out.println("Enter nothing to stop.");
      System.out.print("Please enter the first name #" + count + ": ");
      name = input.next();
      ns.add(name);
      counter++;
    }
  }
}
