package Session02.Bai3;

import java.util.Scanner;

public class Bai3 {
   public static void main(String[] args) {
       Scanner sc =new Scanner(System.in);
       int book,total=0;

       System.out.print("Nhap so luong sach tra muon :");
       book =sc.nextInt();
       for (int i=0;i<book;i++){
           System.out.printf("Nhap so ngay tre cua cuon thu %d: \n",i+1);
           int temp ;
           temp =sc.nextInt();
           total = total+temp;
       }
       System.out.printf("===> Tong tien phat: %d",total*5000);
    }
}
