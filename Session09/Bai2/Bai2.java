package Session09.Bai2;
class Animal {
    public void sound() {
        System.out.println("Tieng keu");
    }
}
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Gau Gau");
    }
}
class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("meo meo");
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound();
        a2.sound();
    }
}

