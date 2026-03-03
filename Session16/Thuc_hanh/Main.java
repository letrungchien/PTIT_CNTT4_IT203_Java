package Session16.Thuc_hanh;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ProductRepository repo =new ProductRepository();

        repo.add(new ElectronicProduct("SP01","Điện thoại",1000000,24));
        repo.add(new ElectronicProduct("SP02","Laptop",23000000,9));
        repo.add(new FoodProduct("F01", "Milk", 30000, 10));
        repo.add(new FoodProduct("F02","Cake",40000,20) );

        System.out.println("tim san pham");
        Product found = repo.findById("F01");
        if (found != null) {
            found.displayInfo();
        } else {
            System.out.println("Khong tim thay!");
        }


        System.out.println("Sap xep gia tang dan");
        List<Product> sortedList = new ArrayList<>(repo.findAll());
        Collections.sort(sortedList, Comparator.comparingDouble(Product::getPrice));

        for (Product p : sortedList) {
            System.out.println(p.getId() + " - " + p.getPrice());
        }


        System.out.println("Thong ke");
        Map<String, Integer> stats = repo.statisticsByType();
        for (String key : stats.keySet()) {
            System.out.println(key + ": " + stats.get(key));
        }

    }
}
