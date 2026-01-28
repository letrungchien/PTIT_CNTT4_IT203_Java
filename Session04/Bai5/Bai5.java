package Session04.Bai5;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai5 {
    static void main(String[] args) {

        String data = "2024-05-20/NguyenVanA/BORROW/BK12345";
        String regex =
                "^(\\d{4}-\\d{2}-\\d{2})" +
                        "/(\\w+)" +
                        "/([A-Z]+)" +
                        "/([A-Z]{2}\\d{5})$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(data);

        if (m.matches()){
            System.out.println("Ngay : " + m.group(1));
            System.out.println("Nguoi dung : " + m.group(2));
            System.out.println("Hanh dong : " + m.group(3));
            System.out.println("Ma Sach : " + m.group(4));
        }


    }
}
