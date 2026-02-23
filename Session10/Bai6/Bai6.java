package Session10.Bai6;

import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}

public class Bai6 {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        list.add(new Product("Laptop", 1500));
        list.add(new Product("Phone", 800));
        list.add(new Product("Tablet", 1000));

        List<Product> sortByPrice = new ArrayList<>(list);
        Collections.sort(sortByPrice, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        System.out.println("Sap xep theo gia tang dan (Anonymous Class):");
        for (Product p : sortByPrice) {
            System.out.println(p);
        }

        List<Product> sortByName = new ArrayList<>(list);
        Collections.sort(sortByName, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        System.out.println("\nSap xep theo ten A-Z (Lambda):");
        for (Product p : sortByName) {
            System.out.println(p);
        }
    }
}