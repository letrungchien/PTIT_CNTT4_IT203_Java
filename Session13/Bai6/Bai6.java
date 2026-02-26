package Session13.Bai6;

import java.util.*;

class Medicine {
    String drugId;
    String drugName;
    double unitPrice;
    int quantity;

    public Medicine(String drugId, String drugName, double unitPrice, int quantity) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public double getTotal() {
        return unitPrice * quantity;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-10.0f %-8d %-12.0f",
                drugId, drugName, unitPrice, quantity, getTotal());
    }
}

public class Bai6 {

    static List<Medicine> cart = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MENU KÊ ĐƠN =====");
            System.out.println("1. Thêm thuốc");
            System.out.println("2. Điều chỉnh số lượng");
            System.out.println("3. Xóa thuốc");
            System.out.println("4. In hóa đơn");
            System.out.println("5. Tìm thuốc giá < 50.000");
            System.out.println("6. Thoát");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addMedicine();
                case 2 -> updateQuantity();
                case 3 -> removeMedicine();
                case 4 -> printBill();
                case 5 -> findCheapMedicine();
                case 6 -> { return; }
                default -> System.out.println("Chọn sai!");
            }
        }
    }
    static void addMedicine() {
        System.out.print("Mã thuốc: ");
        String id = sc.nextLine();

        for (Medicine m : cart) {
            if (m.drugId.equals(id)) {
                System.out.print("Nhập số lượng thêm: ");
                m.quantity += Integer.parseInt(sc.nextLine());
                System.out.println("Đã cộng dồn số lượng!");
                return;
            }
        }

        System.out.print("Tên thuốc: ");
        String name = sc.nextLine();
        System.out.print("Đơn giá: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Số lượng: ");
        int qty = Integer.parseInt(sc.nextLine());

        cart.add(new Medicine(id, name, price, qty));
        System.out.println("Thêm thuốc thành công!");
    }


    static void updateQuantity() {
        System.out.print("Nhập mã thuốc: ");
        String id = sc.nextLine();

        for (Medicine m : cart) {
            if (m.drugId.equals(id)) {
                System.out.print("Nhập số lượng mới: ");
                int qty = Integer.parseInt(sc.nextLine());

                if (qty == 0) {
                    cart.remove(m);
                    System.out.println("Đã xóa thuốc khỏi đơn!");
                } else {
                    m.quantity = qty;
                    System.out.println("Cập nhật thành công!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy thuốc!");
    }

    static void removeMedicine() {
        System.out.print("Nhập mã thuốc cần xóa: ");
        String id = sc.nextLine();

        Iterator<Medicine> it = cart.iterator();
        while (it.hasNext()) {
            if (it.next().drugId.equals(id)) {
                it.remove();
                System.out.println("Đã xóa thuốc!");
                return;
            }
        }
        System.out.println("ID không tồn tại!");
    }

    static void printBill() {
        if (cart.isEmpty()) {
            System.out.println("Đơn thuốc trống!");
            return;
        }

        double total = 0;
        System.out.printf("%-10s %-15s %-10s %-8s %-12s\n",
                "ID", "Tên", "Giá", "SL", "Thành tiền");

        for (Medicine m : cart) {
            System.out.println(m);
            total += m.getTotal();
        }

        System.out.println("---------------------------------------------");
        System.out.println("TỔNG TIỀN: " + total + " VNĐ");

        cart.clear();
    }

    static void findCheapMedicine() {
        boolean found = false;
        for (Medicine m : cart) {
            if (m.unitPrice < 50000) {
                System.out.println(m.drugName + " - " + m.unitPrice);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có thuốc giá dưới 50.000");
        }
    }
}
