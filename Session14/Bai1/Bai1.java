package Session14.Bai1;

import java.util.HashSet;
import java.util.Set;

public class Bai1 {
    public static void main(String[] args) {
        Set<String> bn = new HashSet<>();
         bn.add("Nguyễn Văn A – Yên Bái");
         bn.add("Trần Thị B – Thái Bình");
         bn.add("Nguyễn Văn A – Yên Bái");
         bn.add("Lê Văn C – Hưng Yên");

         for (String i :bn){
             System.out.print(i +" ");
         }



    }
}
