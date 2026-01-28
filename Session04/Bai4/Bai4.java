package Session04.Bai4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai4 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "^[A-Z]{2}\\d{4}\\d{5}$";
        Pattern patten = Pattern.compile(regex);
        String cardId;
        System.out.println("Nhap :");
        cardId = sc.nextLine();
        Matcher matcher = patten.matcher(cardId);
        if (matcher.find()) System.out.println("hop le");
        else System.out.println("khong hop le");
    }
}