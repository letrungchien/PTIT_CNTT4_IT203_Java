package Session02.Bai2;

import java.util.Scanner;

public class Bai2 {
  public   static void main(String[] args) {
      Scanner sc =new Scanner(System.in);
      char ma;
      System.out.print("Nhap ma khu vuc (A,B,C,D):");
      ma =sc.next().charAt(0);
      switch (ma){
          case 'A':
              System.out.print("Vi tri: Tang 1 -Sach van hoc");
           break;
          case 'B':
              System.out.print("Vi tri: Tang 2 -Sach khoa hoc");
              break;
          case 'C':
              System.out.print("Vi tri: Tang 3 -Sach ngoai ngu");
              break;
          case 'D':
              System.out.print("Vi tri: Tang 4 -Sach tin hoc");
              break;
          default:
              System.out.print("Loi: Ma khu vuc khong hop le");
              break;
      }
    }

}
