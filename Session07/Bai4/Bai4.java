package Session07.Bai4;
class ClassRoom{
  public  static  double classFund = 0;
  String name;
  public ClassRoom(String name) {
    this.name = name;
  }
  public void dongQuy(double tien){
    classFund +=tien;
    System.out.println("Sinh viên "+name+ " đã đóng "+tien+ " vào quỹ ");
  }
  public void  tongTien(){
    System.out.println("Tổng quỹ của "+name+" là " +classFund +"đ");
  }
}
public class Bai4 {
  public static void main(String[] args) {
      ClassRoom sv1 =new ClassRoom("Chiến");
      sv1.dongQuy(1000000);
      sv1.tongTien();
  }
}
