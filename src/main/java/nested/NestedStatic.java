package main.java.nested;

import java.util.ArrayList;
import java.util.function.Predicate;

public class NestedStatic {

    // Innere statische Klasse kann auch 'public' sein. Dann kann sie auch außerhalb des Pakets instantiiert werden.
    public static class MyNestedClass implements Predicate<String> {
        String s = "Hallo";

        public MyNestedClass( String s ) {
            this.s = s;
        }

        @Override
        public boolean test( String s ) {
            return s.equals( this.s );
        }
    }

    public static void main( String[] args ) {
        Predicate<String> predicate = new MyNestedClass( "Hallo" );
        ArrayList<String> list = new ArrayList<>();
        list.add( "Hallo" );
        System.out.println( list );
        list.removeIf( predicate );
        System.out.println( list );

    }
}

class Outter {
    // Hier muss ich dann den Namen der äußeren Klasse mit angeben, da ich sonst nicht an die
    // innere statische Klasse komme.
    NestedStatic.MyNestedClass nestedClass;

    public Outter() {

    }
}
