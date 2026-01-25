package Session01.Bai4;
import java.util.Scanner;

public class Bai4 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float moneyExchangeRate = 25450.0F;
        System.out.print("Nhập giá sách (USD) : ");
        double moneyUSD = sc.nextDouble();
        System.out.println("Giá chính xác là : " + (moneyUSD * moneyExchangeRate));
        System.out.println("Giá làm tròn để thanh toán là : " + ((long)Math.ceil(moneyUSD * moneyExchangeRate)));
    }
}
