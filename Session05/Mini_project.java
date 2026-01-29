package Session05;

import java.util.Arrays;
import java.util.Scanner;

public class Mini_project {
    // FR1
    public static void twoSum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử mảng: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Mảng rỗng!");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Nhập target: ");
        int target = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Tìm thấy cặp chỉ số: (" + i + ", " + j + ")");
                    return;
                }
            }
        }

        System.out.println("Không tìm thấy cặp số phù hợp!");
    }

    // CASE 2
    public static void moveZeroes(int[] nums) {
        int viTri = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[viTri++] = nums[i];
            }
        }

        for (int i = viTri; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void caseMoveZeroes() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng số nguyên: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Nhập số nguyên thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Mảng trước khi dồn 0: " + Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println("Mảng sau khi dồn 0: " + Arrays.toString(arr));
    }

    // CASE 3
    public static void checkPalindrome() {
        Scanner sc = new Scanner(System.in);

        sc.nextLine();
        System.out.print("Nhập vào câu cần kiểm tra: ");
        String title = sc.nextLine();

        String cleanStr = title.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedStr = new StringBuilder(cleanStr).reverse().toString();

        System.out.println("Chuỗi sau khi làm sạch: " + cleanStr);
        System.out.println("Kết quả đối xứng: " + cleanStr.equals(reversedStr));
    }

    // CASE 4
    public static void reverseWords() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();

        String[] words = input.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }

        System.out.println("Chuỗi sau xử lý:");
        System.out.println(sb.toString());
    }

    // CASE 5
    public static void happyNumber() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số n: ");
        int n = sc.nextInt();
        int original = n;

        while (n != 1 && n != 4) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }

        if (n == 1)
            System.out.println(original + " là số hạnh phúc (Happy Number)");
        else
            System.out.println(original + " không phải là số hạnh phúc");
    }

    // MENU
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Two Sum");
            System.out.println("2. Move Zeroes");
            System.out.println("3. Kiểm tra chuỗi đối xứng");
            System.out.println("4. Đảo ngược từ trong câu");
            System.out.println("5. Happy Number");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    twoSum();
                    break;
                case 2:
                    caseMoveZeroes();
                    break;
                case 3:
                    checkPalindrome();
                    break;
                case 4:
                    reverseWords();
                    break;
                case 5:
                    happyNumber();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }
}