package Session11;
public class Thuc_hành {

    interface IMixable {
        void mix();
    }


    static abstract class Drink {
        protected String id;
        protected String name;
        protected double price;

        public Drink(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public abstract double calculatePrice();

        public void displayInfo() {
            System.out.println("Mã: " + id);
            System.out.println("Tên: " + name);
            System.out.println("Giá gốc: " + price);
        }
    }


    static class Coffee extends Drink implements IMixable {

        private boolean hasMilk;

        public Coffee(String id, String name, double price, boolean hasMilk) {
            super(id, name, price);
            this.hasMilk = hasMilk;
        }

        @Override
        public double calculatePrice() {
            if (hasMilk) {
                return price + 5000;
            }
            return price;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            if (hasMilk) {
                System.out.println("Loại: Có sữa");
            } else {
                System.out.println("Loại: Đen đá");
            }
            System.out.println("Giá thực tế: " + calculatePrice());
        }

        @Override
        public void mix() {
            System.out.println("Đang pha chế cà phê...");
        }
    }

    public static void main(String[] args) {
        Coffee cf1 = new Coffee("CF01", "Cà phê sữa", 20000, true);
        Coffee cf2 = new Coffee("CF02", "Cà phê đen", 18000, false);

        cf1.mix();
        cf1.displayInfo();

        System.out.println("------------");

        cf2.mix();
        cf2.displayInfo();
    }
}

