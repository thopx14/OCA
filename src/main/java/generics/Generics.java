package main.java.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    static class Pair<T, U> {
        T first;
        U second;

        public Pair( T first, U second ) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }

        public T getFirst() {
            return first;
        }

        public void setFirst( T first ) {
            this.first = first;
        }

        public U getSecond() {
            return second;
        }

        public void setSecond( U second ) {
            this.second = second;
        }
    }

    public static void main( String[] args ) {
        Pair<String, String> pair1 = new Pair<>( "Hallo", "Welt" );
        Pair<Double, String> pair2 = new Pair<>( 12.0, "Huhu" );

        /*
            Das geht nicht! Zur Laufzeit fliegen die generischen Typen raus und
            es entsteht nur noch der 'Pair' Typ.
         */
//        Pair<String, Double>[] pairArray = new Pair<String, Double>[10];

        // Es wird nur jeweils Pair.class mit Pair.class verglichen!
        System.out.println( pair1.getClass() == pair2.getClass() );
        // Hier verlieren sich die generischen Typen.
        System.out.println( pair1.getClass() ); // class main.java.generics.Generics$Pair

        /*
            Folgendes geht auch nicht so wirklich...
         */

        // Hier geht die Typ-Anpassung verloren. Sie ist allerdings zur Laufzeit eh nicht vorhanden!
        Pair newPair = pair1;                       // Hier geht die Typ-Anpassung verloren.
        newPair.setFirst( 1200L );                  // Geht, da der Typ jetzt Object ist (Raw-Type)!
        Pair<String, Double> newPair2 = newPair;    // pair1 enthält ja <String, String>. Geht also verloren!

        System.out.println( newPair );
        System.out.println( newPair2 );

        /*
            Auch hier geht es nicht mit Generics:
         */
        Pair<String, Double>[] pArray = new Pair[10]; // Hier entsteht ein Pair-Array vom Raw-Type.


        List<String> strings = new ArrayList<>();
        strings.add( "Hallo" );

        String test = firstOrElse( strings, "Welt" );
        System.out.println( test );

        strings.remove( "Hallo" );
        test = firstOrElse( strings, "Welt" );
        System.out.println( test );
    }

    /*
        Mit <T> wird angegeben, dass in der Methode ein generischer Typ verwendet wird.
        Dieser Typ kann dann mit 'T' als Rückgabewert definiert werden und ebenfalls im Methodenrumpf
        wiederverwendet werden.
     */
    static <T> T firstOrElse( List<T> list, T defaultVal ) {
        if ( list.size() > 0 ) {
            return list.get( 0 );
        }
        return defaultVal;
    }
}
