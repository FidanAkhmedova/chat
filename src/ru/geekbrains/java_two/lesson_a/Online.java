package ru.geekbrains.java_two.lesson_a;

class Animal {
    void voice() {}
    void move(){
        System.out.println("cat walks on paws");
    }
}

class Cat extends Animal {
    Cat() {
        this.move();
    }
    void purr() {
        System.out.println("purrrr");
    }
}

class Snake extends Animal {
    @Override
    void move() {
        System.out.println("snake crawls");
    }
}
public class Online {
    public static void main(String[] args) {
        Animal[] zoo = {new Cat(), new Snake()};
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].move();
            if (zoo[i] instanceof Cat) {
                ((Cat) zoo[i]).purr();
            }
        }

        byte b = 50;
        int i = b;
        System.out.println(i);
        int i0 = 50;
        byte b0 = (byte) i0;

    }
}
