package main.java.vererbung.aufgaben;

public class SuperKonstruktoren {
    public static void main( String[] args ) {
        new C();
    }
}

class A {
    private String s;

    // Wird automatisch vom Compiler generiert, falls kein anderer Konstruktor vorhanden ist.
//    A() {
//        super();
//    }

    A( String s ) {
        // super(); <-- wird automatisch generiert.
        this.s = s;
//        super(); <-- geht nicht, da super() immer am Anfang stehen muss!
    }
}

class B extends A {
    int x;

    B( String s ) {
//        this.x = 10;  <-- geht nicht, da this(...) und super(...) jeweils am Anfang stehen müssen!
        // Beides gleichzeitig geht dann nicht.
        super( s );
        this.x = 10;
    }
}

class C extends A {

//    C() { } <-- geht nicht, da super() fehlt!

    C() {
        super( "C" );
    }

    C( String s ) {
        super( s );
    }
}
