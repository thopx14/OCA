package main.java.vererbung.aufgaben;

abstract class bla {
    abstract void method();
}

abstract class Figure {

}

class Cycle extends Figure {

}

public class AbstractClass {
    public static void main( String[] args ) {

//        new Figure(); // cf: Keine Instantiierung von abstrakten Klassen möglich!
        new Figure() {
        }; // kein cf, da innere anonyme Klasse!

//        new bla() {}; // cf: Abstrakte Methode 'method' nicht ausimplementiert.
    }
}
