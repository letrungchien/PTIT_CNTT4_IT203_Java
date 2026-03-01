package Session14.Bai4;

import java.util.*;

public class Bai4 {
    public static void main(String[] args) {

        List<String> danhSach = Arrays.asList(
                "Cúm A", "Sốt xuất huyết", "Cúm A",
                "Covid-19", "Cúm A", "Sốt xuất huyết"
        );

        TreeMap<String, Integer> thongKe = new TreeMap<>();

        for (String benh : danhSach) {
            thongKe.put(benh, thongKe.getOrDefault(benh, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : thongKe.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ca");
        }
    }
}
