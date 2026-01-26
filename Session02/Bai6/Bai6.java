package Session02.Bai6;

import java.util.Scanner;

public class Bai6 {
   public  static void main(String[] args) {
       Scanner sc =new Scanner(System.in);
       int min =99;
       int max =0;
       int total =0;
       int count =0;
       for (int i=2 ;i<9;i++){
        if(i == 8){
            System.out.print("Nhap luot muon ngay chu nhat:");
        }else {
            System.out.printf("Nhap luot muon ngay thu %d:",i);
        }
        int muon =sc.nextInt();
        if(muon==0){
            continue;
        }

         if(min >muon){
             min =muon;
         }
         if(max < muon){
             max=muon;
         }

         count ++;
         total=total+muon;
       }

       System.out.println("======Ket qua thong ke=====\n");
       System.out.printf("luot muon cao nhat:%d \n",max);
       System.out.printf("luot muon thap nhat:%d \n",min);
       System.out.printf("Trung binh luot muon/ngay: %d",total/count);
    }
}
