package Session09.Bai3;

class Employee {
     String name;
    double basicSalary;

    public Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }
}
class Manager extends Employee {
    private String department;

    public Manager(String name, double basicSalary, String department) {
        super(name, basicSalary);
        this.department = department;
    }

    public void display() {
        System.out.println("Tên: " + name);
        System.out.println("Lương cơ bản: " + basicSalary);
        System.out.println("Phòng ban: " + department);
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Manager m = new Manager("Chiến", 15000000, "IT");
        m.display();
    }
}

