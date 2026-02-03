package Session08_1;

import java.util.Scanner;

class  Student{
    private String id;
    private String name;
    private double score;

    public Student(){
        this.id="";
        this.name="";
        this.score=0;
    }
    public Student(String id ,String name,double score){
        this.id=id;
        this.name=name;
        this.score=score;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getScore(){
        return score;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setScore(double score){
        this.score=score;
    }

    public String getRank(){
        if (score>=8.0){
            return "Gioi";
        } else if ( score >=6.5 && score < 8.0) {
            return "kha";
        }else {
            return "Trung binh";
        }
    }
    @Override
    public String toString() {
        return String.format("ID: %s | Tên: %-15s | Điểm: %.2f | Học lực: %s",
               id, name, score, getRank());
    }
}
class StudentManager{
    private Student[] students;
    private int count ;
    public StudentManager() {
        this.count = 0;
    }
    public boolean addStudent(Student s) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equalsIgnoreCase(s.getId())) {
                System.out.println("Mã sinh viên đã tồn tại");
                return false;
            }
        }

        students[count++] = s;
        return true;
    }

    public void displayAllStudents() {
        if (count == 0) {
            System.out.println("Danh sách sinh viên đang trống!");
            return;
        }

        System.out.println("\n================= DANH SÁCH SINH VIÊN =================");
        System.out.printf("%-8s %-20s %-5s %-10s %-8s %-12s\n",
                "Mã SV", "Họ tên", "Điểm", "Học lực");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            Student s = students[i];
            System.out.printf("%-8s %-20s %-2fd %-10s\n",
                    s.getId(),
                    s.getName(),
                    s.getScore(),
                    s.getRank());
        }
    }

}
public class Thuc_hanh_ss8 {
  public  static void main(String[] args) {
      StudentManager manager = new StudentManager();
      Scanner sc = new Scanner(System.in);
      int choice;

      do {
          System.out.println("===== QUẢN ẢN LÝ ĐIỂM SINH VIÊN =====");
          System.out.println("1. Nhập ập danh sách sinh viên");
          System.out.println("2. Hiển thị danh sách sinh viên");
          System.out.println("3. Tìm kiếm sinh viên theo Học lực");
          System.out.println("4. Sắp ắp xếp theo học lực giảm dần");
          System.out.println("5. Thoát");
          System.out.println("==================================");
          System.out.print("Chọn chức năng:");
          choice = sc.nextInt();
          sc.nextLine();

          switch (choice){
              case 1:
                  System.out.print("Nhập mã SV: ");
                  String id = sc.nextLine();
                  System.out.print("Nhập tên: ");
                  String name = sc.nextLine();
                  System.out.println("Nhập điểm: ");
                  double score = sc.nextDouble();

                  Student newStudent = new Student(id, name, score);
                  if (manager.addStudent(newStudent)) {
                      System.out.println("Thêm thành công!");
                  } else {
                      System.out.println("Thêm thất bại !");
                  }
              break;
              case 2:
                  manager.displayAllStudents();
                  break;
              case 3:
                  break;
              case 4:
                  break;
              case 5:
                  System.out.println("Chương trình kết thúc");
                  break;
              default:
                  System.out.println("Lựa chọn không hợp lệ !");
          }
      }while (choice !=5);

      }
}
