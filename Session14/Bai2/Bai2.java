package Session14.Bai2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Map<String, String> danhMuc = new HashMap<>();

        danhMuc.put("T01", "Paracetamol");
        danhMuc.put("T02", "Ibuprofen");
        danhMuc.put("T03", "Aspirin");
        danhMuc.put("T04", "Amoxicillin");
        danhMuc.put("T05", "Vitamin C");

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã thuốc: ");
        String ma = sc.nextLine();

        if (danhMuc.containsKey(ma)) {
            System.out.println("Tên thuốc: " + danhMuc.get(ma));
        } else {
            System.out.println("Thuốc không tồn tại.");
        }
    }
}
