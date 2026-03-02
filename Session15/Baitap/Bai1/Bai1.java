package Session15.Baitap.Bai1;

import java.util.Scanner;
import java.util.Stack;

public class Bai1 {

    static class EditAction {
        private String description;
        private String time;

        public EditAction(String description, String time) {
            this.description = description;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Mô tả: " + description + " | Thời gian: " + time;
        }
    }

    static Stack<EditAction> editActions = new Stack<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        do {
            menu();
            System.out.print("Nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addEdit();
                    break;
                case 2:
                    EditAction undo = undoEdit();
                    if (undo == null)
                        System.out.println("Danh sách rỗng!");
                    else
                        System.out.println("Đã undo: " + undo);
                    break;
                case 3:
                    EditAction latest = getLatestEdit();
                    if (latest == null)
                        System.out.println("Danh sách rỗng!");
                    else
                        System.out.println("Gần nhất: " + latest);
                    break;
                case 4:
                    System.out.println("Hiện có " + editActions.size() + " chỉnh sửa.");
                    break;
                case 5:
                    System.out.println("Toàn bộ lịch sử:");
                    for (EditAction e : editActions) {
                        System.out.println(e);
                    }
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
        System.out.println("1. Thêm chỉnh sửa");
        System.out.println("2. Undo chỉnh sửa");
        System.out.println("3. Lấy chỉnh sửa gần nhất");
        System.out.println("4. Kiểm tra số lượng");
        System.out.println("5. Hiển thị toàn bộ lịch sử");
        System.out.println("6. Thoát");
    }

    public static void addEdit() {
        System.out.print("Nhập mô tả bệnh án: ");
        String desc = sc.nextLine();

        System.out.print("Nhập thời gian (dd/mm/yyyy): ");
        String time = sc.nextLine();

        EditAction action = new EditAction(desc, time);
        editActions.push(action);

        System.out.println("Thêm thành công!");
    }

    public static EditAction undoEdit() {
        if (editActions.empty())
            return null;
        return editActions.pop();
    }

    public static EditAction getLatestEdit() {
        if (editActions.empty())
            return null;
        return editActions.peek();
    }
}