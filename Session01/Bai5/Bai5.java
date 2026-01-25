package Session01.Bai5;
import java.util.Scanner;

public class Bai5 {
   public static void main(String[] args) {
       Scanner sc =new Scanner(System.in);
       int number ,thousands, hundreds, dozens, units;
       System.out.print("Nhập mã sách có 4 chữ số:");
       number=sc.nextInt();
       units=number % 10;
       dozens =(number /10) %10;
       hundreds =(number/100) %10;
       thousands =number/1000;
       System.out.printf("Chữ số kiểm tra kỳ vọng: %d \n",units);
       int sumOfFirstThreeNumber = thousands + hundreds + dozens;
       boolean isValid = (sumOfFirstThreeNumber % 10) == units;
       System.out.print("kết quả kiểm tra mã sách:" +(isValid?"HỢP LỆ":"SAI MÃ"));
    }
}
