package main.java.nested;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class InnerAnonymousTypes {

    interface MyLocalInterface {
        default void printName() {
            System.out.println( getClass() );
        }
    }

    public static void main( String[] args ) {

        MyLocalInterface myLocalInterface = new MyLocalInterface() {
        };
        myLocalInterface.printName(); //class main.java.nested.InnerAnonymousTypes$1

        // Ziemlich unschön, aber machbar!
        List<String> strings = new ArrayList<>() {
            /* Der Elementinitialisierungsblock wird ans Ende des Standardkonstruktors gesetzt.
                Dort kann man z.B. böse Dinge tun ;-). Soll nur zur Verdeutlichung hier stehen.
             */ {
                add( "Hallo" );
                add( "Welt" );
            }

            @Override
            public String toString() {
                return "Hier könnte toString() stehen ;-)";
            }
        };
        System.out.println( strings );
        // InnerAnonymousTypes wird hochgezählt (hier 2).
        System.out.println( strings.getClass() ); //class main.java.nested.InnerAnonymousTypes$2

        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare( String o1, String o2 ) {
                return o1.compareToIgnoreCase( o2 );
            }
        };

        List<String> strings1 = new ArrayList<>();
        strings1.add( "Hallo" );
        strings1.add( "Welt" );
        strings1.add( "Anfang" );
        strings1.sort( comparator.reversed() );
        System.out.println( strings1 );
        strings1.sort( new Comparator<String>() {
            @Override
            public int compare( String o1, String o2 ) {
                return String.CASE_INSENSITIVE_ORDER.compare( o1, o2 );
            }
        } );
        System.out.println( strings1 );

        List<String> strings2 = new ArrayList<>();
        strings2.add( "Blau" );
        strings2.add( "Beere" );

        System.out.println( strings2 );
        strings2.removeIf( new Predicate<String>() {
            @Override
            public boolean test( String s ) {
                return s.contains( "eer" );
            }
        } );
        System.out.println( strings2 );

    }
}
