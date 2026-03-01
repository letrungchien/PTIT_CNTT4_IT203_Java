package Session14.Bai3;

import java.util.HashSet;
import java.util.Set;

public class Bai3 {
    public static void main(String[] args) {


        Set<String> thuoc = new HashSet<>();
        thuoc.add("Aspirin");
        thuoc.add("Caffeine");
        thuoc.add("Paracetamol");

        Set<String> diUng = new HashSet<>();
        diUng.add("Penicillin");
        diUng.add("Aspirin");

        Set<String> canhBao = new HashSet<>(thuoc);
        canhBao.retainAll(diUng);

        Set<String> anToan = new HashSet<>(thuoc);
        anToan.removeAll(diUng);

        System.out.println("Cảnh báo dị ứng: " + canhBao);
        System.out.println("Thành phần an toàn: " + anToan);
    }
}