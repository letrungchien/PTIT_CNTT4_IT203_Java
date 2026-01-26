package Session02.Bai4;

import java.util.Scanner;

public class Bai4 {
  public static void main(String[] args) {
      Scanner sc =new Scanner(System.in);
      int id ;
      int check=0;
      do{
          System.out.print("Nhap ID sach moi (phai >0):");
          id = sc.nextInt();
          if(id>0){
              System.out.printf("Xac nhan: Ma sach %d da duoc ghi nhan",id);
          }else {
              System.out.print("Loi : ID phai la so duong.Moi nhap lai! \n");
          }
      }while (id <= 0);
    }
}
