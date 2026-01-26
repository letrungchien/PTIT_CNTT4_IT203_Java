package Session02.Bai1;

import java.util.Scanner;

public class Bai1 {
   public static void main(String[] args) {
       Scanner sc =new Scanner(System.in);
       int age,book ;
       System.out.print("Nhap tuoi cua ban :");
        age = sc.nextInt();
       System.out.print("Nhap so sach dang muon :");
       book =sc.nextInt();
      if (age > 18 && book < 3){
          System.out.print("Ket qua: Ban du DIEU KIEN muon sach quy hiem");
      }else if(age >18 && book >= 3) {
          System.out.println("Ket qua: Khong du dieu kien");
          System.out.print("- Ly do:Ban da muon toi da 3 cuon");
      } else {
          System.out.println("Ket qua:Khong du dieu kien");
          System.out.print("- Ly do:Ban phai tu 18 tuoi tro len");
      }

    }

}
