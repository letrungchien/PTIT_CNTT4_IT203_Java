package Session04.Bai2;

public class Bai2 {
  public   static void main(String[] args) {
      String description ="Sách giáo khoa sách toán lớp 12, Kệ: A1-102,tình trạng mới ";


          int start = description.indexOf("Kệ:") + 4;
          int end = description.indexOf(",", start);

          String locationCode = description.substring(start, end).trim();
          String newDescription = description.replace("Kệ:", "Vị trí lưu trữ:");

          System.out.println("Mã vị trí lưu trữ: " + locationCode);
          System.out.println("Mô tả mới: " + newDescription);
    }
}
