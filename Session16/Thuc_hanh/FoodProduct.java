package Session16.Thuc_hanh;

public class FoodProduct extends Product{
   private int discountPercent;

    public FoodProduct(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }
    @Override
   public double calculateFinalPrice(){
        return price - (price * discountPercent / 100);
    }
   public  void displayInfo(){
       super.displayInfo();
       System.out.println("Discount: " + discountPercent + "%");
   }
}
