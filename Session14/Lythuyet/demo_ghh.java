package Session14.Lythuyet;

import java.util.HashSet;
import java.util.Set;

public class demo_ghh {
  public   static void main(String[] args) {
      Set<Integer> set1=new HashSet<>();
      Set<Integer> set2=new HashSet<>();

      set1.add(1);
      set1.add(3);
      set1.add(5);

      set2.add(2);
      set2.add(4);
      set2.add(6);

      Set<Integer> hop   = new HashSet<>();

      hop.addAll(set1);
      hop.addAll(set2);

      for (Integer i : hop){
          System.out.print(i + " ");
      }

  }
}

