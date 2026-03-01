package Session14.Bai6;

import java.util.*;

class Patient {
    String name;
    int age;
    String department;

    public Patient(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }
    public String toString() {
        return name;
    }
}

public class Bai6 {
    public static void main(String[] args) {

        List<Patient> danhSach = Arrays.asList(
                new Patient("Lan", 30, "Tim mạch"),
                new Patient("Hùng", 45, "Nội tiết"),
                new Patient("Mai", 25, "Tim mạch")
        );

        Map<String, List<Patient>> map = new HashMap<>();

        for (Patient p : danhSach) {
            map.putIfAbsent(p.department, new ArrayList<>());
            map.get(p.department).add(p);
        }

        for (String khoa : map.keySet()) {
            System.out.println("Khoa " + khoa + " -> " + map.get(khoa));
        }

        String khoaDongNhat = "";
        int max = 0;

        for (Map.Entry<String, List<Patient>> entry : map.entrySet()) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                khoaDongNhat = entry.getKey();
            }
        }

        System.out.println("Khoa " + khoaDongNhat + " đang đông nhất (" + max + " bệnh nhân)");
    }
}