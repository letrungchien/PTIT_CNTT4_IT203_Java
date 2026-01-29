package Session05;

import java.util.Scanner;

public class Thuc_hanh {
    static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String[] Student =new String[100];
        int n;
        int count =0;
        do {
            System.out.println("=======MENU======");
            System.out.println("1.Hiển thị");
            System.out.println("2.Thêm mới");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xóa");
            System.out.println("5.Tìm kiếm");
            System.out.println("6.Thoát\n");
            System.out.print("Mời bạn lư chọn:");
            n =sc.nextInt();

            switch (n){
                case 1:
                    if(count == 0){
                        System.out.println("danh sách rỗng");
                    }else {
                    for (int i=0;i<count;i++){
                        System.out.println(Student[i]);
                    }
                    }
                    break;
                case 2:
                    String mssv;
                    while (true) {
                        System.out.print("Nhập MSSV: ");
                        mssv = sc.nextLine();

                        if (mssv.matches("^B\\d{7}$")) {
                            Student[count] = mssv;
                            count++;
                            System.out.println("Thêm sinh viên thành công!");
                            break;
                        } else {
                            System.out.println(" MSSV không hợp lệ! ");
                        }
                    }
                    break;
                case 3:
                    int v ;
                    System.out.print("Nhập vị trí cần sửa:");
                    v=sc.nextInt();
                    if(v >= 0 && v<count){
                        String mss;
                        while (true) {
                            System.out.print("Nhập MSSV: ");
                            mss = sc.nextLine();
                            if (mss.matches("^B\\d{7}$")) {
                                Student[v] = mss;
                                System.out.println("Cập nhật sinh viên thành công!");
                                break;
                            } else {
                                System.out.println(" MSSV không hợp lệ! ");
                            }
                        }
                    }else {
                        System.out.println("Vị trí sửa không hợp lệ ");
                    }
                    break;
                case 4:
                    System.out.print("Mời nhập MSSV cần xóa");
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Chương trình kết thúc");
                    break;
                default:
                    System.out.println("Lụa chọn không hợp lệ mời nhập lại.");
            }
        }while (n!=6);
    }
}
