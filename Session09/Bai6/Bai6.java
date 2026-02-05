package Session09.Bai6;

import java.util.ArrayList;

abstract class Shape {
    public abstract double area();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
        this.radius = 1;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;


    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double side) {
        this.width = side;
        this.height = side;
    }

    @Override
    public double area() {
        return width * height;
    }
}

public class Bai6 {
    public static void main(String[] args) {

        ArrayList<Shape> list = new ArrayList<>();
        list.add(new Circle(2));
        list.add(new Rectangle(3, 4));
        list.add(new Rectangle(5));

        double total = 0;

        for (Shape s : list) {
            total += s.area();
        }

        System.out.println("Tổng diện tích: " + total);
    }
}
