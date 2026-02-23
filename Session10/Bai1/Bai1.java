package Session10.Bai1;

interface Shape {
    double getArea();
    double getPerimeter();
}

class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle implements Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

public class Bai1 {
    public static void main(String[] args) {

        Shape circle = new Circle(10);
        Shape rectangle = new Rectangle(5, 8);

        System.out.printf("=== HINH TRON ===\n");
        System.out.printf("Chu vi: %.2f\n", circle.getPerimeter());
        System.out.printf("Dien tich: %.2f\n\n", circle.getArea());

        System.out.printf("=== HINH CHU NHAT ===\n");
        System.out.printf("Chu vi: %.2f\n", rectangle.getPerimeter());
        System.out.printf("Dien tich: %.2f\n", rectangle.getArea());
    }
}