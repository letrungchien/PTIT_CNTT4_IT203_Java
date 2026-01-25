package Session01.Bai2;
import java.util.Scanner;

public class Bai2 {
   public static void main(String[] args) {
       Scanner sc =new Scanner(System.in);
       int m,n,sum;
       System.out.print("Nhập số ngày chậm trễ:");
       n=sc.nextInt();
       System.out.print("Nhập số lượng sách mượn:");
       m=sc.nextInt();
       sum=m*n*5000;
       System.out.printf("Tiền phạt gốc: %d \n",sum);
       if(n>7 && m>=3){
           sum =sum + sum*2/10;
       }
       System.out.printf("Tiền phạt sau điều chỉnh: %d \n",sum);
      System.out.print(sum>500000?"Yêu cầu khóa thẻ : true":"Yêu cầu khóa thẻ : false");
    }
}
