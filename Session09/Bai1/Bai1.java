package Session09.Bai1;



class Person {
     String hoTen;
      int tuoi;

    public Person(String hoTen, int tuoi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public void hienThiThongTin() {
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Tuổi: " + tuoi);
    }
}

class Student extends Person {
    private String maSV;
    private double diemTB;

    public Student(String hoTen, int tuoi, String maSV, double diemTB) {
        super(hoTen, tuoi); // gọi constructor lớp cha
        this.maSV = maSV;
        this.diemTB = diemTB;
    }


    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Mã SV: " + maSV);
        System.out.println("Điểm TB: " + diemTB);
    }
}

public class Bai1 {
    public static void main(String[] args) {
        Student sv = new Student("Lê Trung Chiến", 19, "SV001", 8.5);
        sv.hienThiThongTin();
    }
}


