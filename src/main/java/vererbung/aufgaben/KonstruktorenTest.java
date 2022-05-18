package main.java.vererbung.aufgaben;

import java.util.Random;

class Animal {
    void run() {
        System.out.println( "a" );
    }
}

class Dog extends Animal {
    void run() {
        System.out.println( "d" );
    }
}

public class KonstruktorenTest {

    static Animal get() {
        if ( new Random().nextBoolean() ) {
            return new Animal();
        }
        return new Dog();
    }

    public static void main( String[] args ) {
        Animal a1 = get();
        a1.run();
    }
}


