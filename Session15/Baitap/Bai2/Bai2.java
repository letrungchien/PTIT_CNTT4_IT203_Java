package Session15.Baitap.Bai2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bai2 {

    static class Patient {
        private String id;
        private String name;
        private int age;

        public Patient(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Mã: " + id + " | Tên: " + name + " | Tuổi: " + age;
        }
    }

    static Queue<Patient> patients = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            menu();
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    Patient called = callNextPatient();
                    if (called == null)
                        System.out.println("Danh sách rỗng!");
                    else
                        System.out.println("Đang gọi: " + called);
                    break;
                case 3:
                    Patient next = peekNextPatient();
                    if (next == null)
                        System.out.println("Danh sách rỗng!");
                    else
                        System.out.println("Tiếp theo: " + next);
                    break;
                case 4:
                    if (patients.isEmpty())
                        System.out.println("Danh sách rỗng!");
                    else
                        System.out.println("Đang có " + patients.size() + " bệnh nhân.");
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Không có lựa chọn này!");
            }

        } while (choice != 6);
    }

    public static void menu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Thêm bệnh nhân");
        System.out.println("2. Gọi bệnh nhân");
        System.out.println("3. Xem bệnh nhân tiếp theo");
        System.out.println("4. Kiểm tra hàng đợi");
        System.out.println("5. Hiển thị tất cả");
        System.out.println("6. Thoát");
    }

    public static void addPatient() {
        System.out.print("Nhập mã bệnh nhân: ");
        String id = sc.nextLine();

        System.out.print("Nhập tên bệnh nhân: ");
        String name = sc.nextLine();

        System.out.print("Nhập tuổi bệnh nhân: ");
        int age = sc.nextInt();
        sc.nextLine();

        Patient p = new Patient(id, name, age);
        patients.offer(p);

        System.out.println("Thêm thành công!");
    }

    public static Patient callNextPatient() {
        return patients.poll();
    }

    public static Patient peekNextPatient() {
        return patients.peek();
    }

    public static void display() {
        if (patients.isEmpty())
            System.out.println("Danh sách rỗng!");
        else
            for (Patient p : patients)
                System.out.println(p);
    }
}