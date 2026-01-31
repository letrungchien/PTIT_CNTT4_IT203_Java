package Session06.Bai3;
class Product {
    private String msp;
    private String name ;
    private int price;

    public Product(String msp,String name,int price){
        this.msp =msp;
        this.name=name;
       setPrice(price);
    }
    public void setPrice(int price){
        if(price>0){
            this.price=price;
        }else {
            System.out.println("Gia khong hop le");
        }

    }

    public String getMaSP() {
        return msp;
    }

    public String getTenSP() {
        return name;
    }

    public int  getGiaBan() {
        return price;
    }

}
public class Bai3 {
   public static void main(String[] args) {
        Product sp1 =new Product("SP01","Tivi",200000);
        Product sp2 =new Product("SP02","Chuot",-9);
        System.out.println("Ma san pham :"+sp1.getMaSP());
        System.out.println("Ten san pham :"+sp1.getTenSP());
        System.out.println("Gia :"+sp1.getGiaBan());
    }
}
