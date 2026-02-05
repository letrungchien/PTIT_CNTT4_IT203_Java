package Session09.Bai5;

import java.util.ArrayList;


abstract class Employee {
     String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();
}

class OfficeEmployee extends Employee {
    private double fixedSalary;

    public OfficeEmployee(String name, double fixedSalary) {
        super(name);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculateSalary() {
        return fixedSalary;
    }
}

class ProductionEmployee extends Employee {
    private int products;
    private double salaryPerProduct;

    public ProductionEmployee(String name, int products, double salaryPerProduct) {
        super(name);
        this.products = products;
        this.salaryPerProduct = salaryPerProduct;
    }

    @Override
    public double calculateSalary() {
        return products * salaryPerProduct;
    }
}

public class Bai5 {
    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new OfficeEmployee("An", 10000000));
        list.add(new ProductionEmployee("Bình", 200, 50000));

        double total = 0;

        for (Employee e : list) {
            double salary = e.calculateSalary();
            System.out.println(e.name + " lương: " + salary);
            total += salary;
        }

        System.out.println("Tổng lương: " + total);
    }
}

