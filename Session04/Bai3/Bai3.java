package Session04.Bai3;

public class Bai3 {
   public static void main(String[] args) {
       String[] transantions = {"BK001-20/01" , "BK005-21/01" , "BK099-22/01"};
       StringBuilder sb = new StringBuilder();

       for (int i = 0 ; i < transantions.length ; i++){
           sb.append("Giao dich : ").append(transantions[i]).append("\n");
       };
       System.out.println(sb.toString());
    }

}
