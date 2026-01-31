package Session06.Bai5;
class  Book{
    private String ma;
    private  String ten;
    private int gia;

    public Book(String ma ,String ten,int gia){
        this.ma =ma;
        this.ten=ten;
        this.gia =gia;
    }
    public void print(){
        System.out.println("Ma sach: "+ma);
        System.out.println("Ten sach: "+ten);
        System.out.println("Gia sach: "+gia);
    }
}
public class Bai5 {
  public   static void main(String[] args) {
        Book bk1= new Book("BK01","Tap ve",80000);
        bk1.print();
    }
}
