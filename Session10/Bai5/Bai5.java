package Session10.Bai5;

abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public abstract double calculateSalary();

    public void displayInfo() {
        System.out.println("Tên: " + name);
        System.out.println("Lương cơ bản: " + baseSalary);
    }
}
interface BonusCalculator {
    double getBonus();
}
class OfficeStaff extends Employee {

    public OfficeStaff(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}
class Manager extends Employee implements BonusCalculator {

    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double getBonus() {
        return bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}
public class Bai5 {
    public static void main(String[] args) {

        Employee[] employees = {
                new OfficeStaff("Nguyễn Văn A", 8000),
                new Manager("Trần Văn B", 15000, 5000),
                new OfficeStaff("Lê Văn C", 9000),
                new Manager("Phạm Văn D", 20000, 7000)
        };

        System.out.println("===== BẢNG LƯƠNG NHÂN VIÊN =====");

        for (Employee emp : employees) {
            emp.displayInfo();

            if (emp instanceof BonusCalculator) {
                BonusCalculator bc = (BonusCalculator) emp;
                System.out.println("Thưởng KPI: " + bc.getBonus());
            } else {
                System.out.println("Thưởng KPI: Không có");
            }

            System.out.println("Lương cuối: " + emp.calculateSalary());
            System.out.println("---------------------------");
        }
    }
}

