package Session02.Bai5;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int reputation = 100;
        int n = 0;
        while (n != 999) {
            System.out.print("(Nhap so ngay tre .nhap 999 de ket thuc) \n");
            System.out.print("So ngay tre cua lan nay:");
            n = sc.nextInt();
            if (n <= 0) {
                reputation = reputation + 5;
                System.out.print("tra dung +5 diem");
            } else if (n != 999) {
                reputation = reputation - n * 2;
                System.out.printf("-> tra tre %d ngay:-%d diem \n",n,n*2);
            }else {
                System.out.printf("Tong diem uy tin: %d \n",reputation);
                if(reputation >120){
                    System.out.print("Doc gia than thiet");
                } else if (reputation >=80 && reputation <= 120) {
                    System.out.print("Doc gia tieu chuan");
                }else {
                    System.out.print("Doc gia can luu y");
                }
            }

        }

    }
}