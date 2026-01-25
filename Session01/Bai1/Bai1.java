
package Session01.Bai1;

import java.util.Scanner;

public class Bai1 {

    public static void main( String[] args) {
        Scanner sc =new Scanner(System.in);
        String book_id ;
        String book_name;
        int publishYear;
        double price;
        boolean isAvailable;

        System.out.print("Nhập mã sách: ");
        book_id =sc.nextLine();
        System.out.print("Nhập tên sách: ");
        book_name=sc.nextLine();
        System.out.print("Nhập năm xuất bản: ");
        publishYear =sc.nextInt();
        System.out.print("Nhập giá bìa: ");
        price =sc.nextDouble();
        System.out.print("Sách còn trong kho(true/false) ");
        isAvailable =sc.nextBoolean();

        System.out.println("------PHIẾU THÔNG TIN SÁCH----");
        System.out.printf("Tên sách : %s \n",book_name);
        System.out.printf("Mã số : %s |Tuổi thọ: %d \n",book_id,2026-publishYear);
        System.out.printf("Giá bán : %2f \n",price);
        if(isAvailable){
            System.out.print("Còn sách");
        }else{
            System.out.print("Không còn sách");
        }

    }
}

