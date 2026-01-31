package Session06.Bai1;
class Student {
   String msv;
    String hoTen;
    String namSinh;
    int tb;

   public Student(String msv, String hoTen, String namSinh, int tb){
       this.msv=msv;
       this.hoTen=hoTen;
       this.namSinh=namSinh;
       this.tb=tb;
   }
   public void printStudent(){
       System.out.println("Mã SV: " + msv);
       System.out.println("Họ tên: " + hoTen);
       System.out.println("Năm sinh: " + namSinh);
       System.out.println("Điểm TB: " + tb);
   }
}

public class Bai1 {
  public   static void main(String[] args) {

 Student sv1 =new Student("Sv01","Lê Chiến","2006",10);
 Student sv2 =new Student("Sv02","Lê Thị C","1999",6);

 sv1.printStudent();
 sv2.printStudent();
    }
}