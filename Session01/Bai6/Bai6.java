package Session01.Bai6;
import java.util.Scanner;
public class Bai6 {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thứ tự cuốn sách: ");
        int stt = sc.nextInt();

        int ke = (stt - 1) / 25 + 1;
        int viTri = (stt - 1) % 25 + 1;

        String khuVuc = (ke <= 10) ? "Khu Cận" : "Khu Viễn";

        System.out.println(
                "Kệ số " + ke + " - Vị trí " + viTri + " - Khu vực " + khuVuc
        );
    }
}
