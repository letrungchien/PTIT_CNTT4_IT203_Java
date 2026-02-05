package Session09.Bai4;

class Animal {
    public void sound() {
        System.out.println("Tiếng kêu");
    }
}
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Gâu gâu");
    }

    public void wagTail() {
        System.out.println("meo meo");
    }
}

public class Bai4 {
    public static void main(String[] args) {

        Animal animal = new Dog();
        animal.sound();
        if (animal instanceof Dog) {
            Dog d = (Dog) animal;
            d.wagTail();
        }
    }
}
