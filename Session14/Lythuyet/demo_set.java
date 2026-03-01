package Session14.Lythuyet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class demo_set {
  public   static void main(String[] args) {
      Set<Integer> list =new HashSet<>();

      list.add(1);
      list.add(2);
      list.add(2);

      System.out.println("danh sach cac phan tu khong trung lap");

      for (Integer i : list){
          System.out.print(i+" ");

      }


    }

}
