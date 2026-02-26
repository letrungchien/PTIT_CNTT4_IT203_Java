package Session13.lythuyet;

import java.util.LinkedList;
import java.util.List;

public class lythuyet {
   public static void main(String[] args) {
       List<Integer> nu = new LinkedList<>();
       nu.add(1);
       nu.add(2);
       nu.add(3);
       nu.add(4);

       System.out.print("danh sach \n");
       for(Integer x :nu){
           System.out.println(x);
       }

       System.out.println(nu.size());
        System.out.println(nu.iterator().hasNext());

    }

}
