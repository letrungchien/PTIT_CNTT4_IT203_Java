package Session07.Bai1;
class Student {
  String msv;
  String ten;
  public static int totalStudent =0;

  public Student(String msv ,String ten){
      this.msv=msv;
      this.ten=ten;
      totalStudent ++;
  }
  public void print(){
      System.out.println("Ma sinh vien: "+msv);
      System.out.println("Ten sinh vien: "+ten);
      System.out.println("-------------------");
  }
  public static void printTotalStudent(){
      System.out.printf("Tong so luong sinh vien la: %d\n",totalStudent);
  }
}
public class Bai1 {
 public   static void main(String[] args) {
        Student sv1 =new Student("S01","Anh");
        Student sv2 =new Student("S02","Lan");

        sv1.print();
        sv2.print();
        Student.printTotalStudent();
    }
}
