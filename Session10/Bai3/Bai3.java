package Session10.Bai3;

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}

interface Swimmable {
    void swim();
}

interface Flyable {
    void fly();
}

class Duck extends Animal implements Swimmable, Flyable {

    public Duck(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(name + " dang boi");
    }

    @Override
    public void fly() {
        System.out.println(name + " dang bay");
    }
}

class Fish extends Animal implements Swimmable {

    public Fish(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(name + " dang boi");
    }
}

public class Bai3 {
    public static void main(String[] args) {

        Duck duck = new Duck("Vit");
        Fish fish = new Fish("Ca");

        duck.swim();
        duck.fly();

        fish.swim();
    }
}