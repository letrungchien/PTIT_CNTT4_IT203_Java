package Session10.Baitaphop;


import java.util.Scanner;

public class Baitaphop2 {
   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
   int chon ;
    do {
        System.out.println("\n===== QUẢN LÝ NHÂN SỰ =====");
        System.out.println("1. Thêm nhân sự");
        System.out.println("2. Hiển thị danh sách");
        System.out.println("3. Tìm theo ID");
        System.out.println("4. Xóa theo ID");
        System.out.println("0. Thoát");
        System.out.print("Mời bạn lựa chon: ");
        chon =sc.nextInt();

        switch (chon){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
                System.out.println("Chương trình kết thúc");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ !");
        }

    }while(chon !=0);
}
}