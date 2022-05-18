package main.java.vererbung.aufgaben;

/**
 * F1.
 */
class Base {
}

class Derived extends Base {
}

/**
 * F2.
 */

class Base2 {
    void m() {
    }
}

class Derived2 extends Base2 {
//    public int m() { return - 1; } // cf: return type!
}

/**
 * F3.
 */

public class Beispielfragen {
    public static void main( String[] args ) {
        Base b1 = ( Base ) new Base();
        Base b2 = ( Base ) new Derived();
        Derived d1 = ( Derived ) new Base(); // ClassCastException: Vererbungslinie nach oben geht nicht!
        Derived d2 = ( Derived ) new Derived();
    }
}
