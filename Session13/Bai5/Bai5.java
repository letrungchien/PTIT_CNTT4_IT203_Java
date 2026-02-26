package Session13.Bai5;

import java.util.*;

class Patient {
    String id;
    String fullName;
    int age;
    String diagnosis;

    public Patient(String id, String fullName, int age, String diagnosis) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return id + " | " + fullName + " | " + age + " | " + diagnosis;
    }
}

public class Bai5 {

    static ArrayList<Patient> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tiếp nhận bệnh nhân");
            System.out.println("2. Cập nhật chẩn đoán");
            System.out.println("3. Xuất viện");
            System.out.println("4. Sắp xếp danh sách");
            System.out.println("5. Thoát");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> updateDiagnosis();
                case 3 -> dischargePatient();
                case 4 -> sortPatients();
                case 5 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Chọn sai!");
            }
        }
    }
    
    static void addPatient() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        for (Patient p : list) {
            if (p.id.equals(id)) {
                System.out.println("ID đã tồn tại!");
                return;
            }
        }

        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = sc.nextLine();

        list.add(new Patient(id, name, age, diagnosis));
        System.out.println("Thêm thành công!");
    }


    static void updateDiagnosis() {
        System.out.print("Nhập ID cần sửa: ");
        String id = sc.nextLine();

        for (Patient p : list) {
            if (p.id.equals(id)) {
                System.out.print("Nhập chẩn đoán mới: ");
                p.diagnosis = sc.nextLine();
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân!");
    }


    static void dischargePatient() {
        System.out.print("Nhập ID cần xuất viện: ");
        String id = sc.nextLine();

        Iterator<Patient> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().id.equals(id)) {
                it.remove();
                System.out.println("Xuất viện thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân!");
    }

    static void sortPatients() {

        list.sort((p1, p2) -> {
            if (p2.age != p1.age) {
                return p2.age - p1.age;
            }
            return p1.fullName.compareTo(p2.fullName); // tên A-Z
        });

        System.out.println("Danh sách sau khi sắp xếp:");
        for (Patient p : list) {
            System.out.println(p);
        }
    }
}
