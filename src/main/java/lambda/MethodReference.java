package main.java.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class MethodReference {
    public static void main( String[] args ) {

        /*
            So wird die Schreibweise immer kürzer.
            Zum Schluss steht dort nut eine Methodenreferenz auf eine statische Methode.
         */
        CharToStringFunction charToStringFunction1 = ( char[] c ) -> {return String.valueOf( c );};
        CharToStringFunction charToStringFunction2 = ( char[] c ) -> String.valueOf( c );
        CharToStringFunction charToStringFunction3 = c -> String.valueOf( c );
        CharToStringFunction charToStringFunction4 = String::valueOf;

        /*
            Man kann natürlich auch ein neues String-Objekt erzeugen:
         */
        CharToStringFunction charToStringFunction5 = ( char[] c ) -> {return new String( c );};
        // ...
        // So lässt sich leicht ein neues Objekt mithilfe des passenden Konstruktors erzeugen ( new String(char[] c) )
        CharToStringFunction charToStringFunction6 = String::new;

        ArrayList<String> strings = new ArrayList<>();
        strings.add( "Welt" );
        strings.add( "Hallo" );

        // int compare(T o1, T o2)
        //=================================
        // 1. Anonyme innere Klasse
        Comparator<String> stringComparator0 = new Comparator<String>() {
            @Override
            public int compare( String o1, String o2 ) {
                return o1.compareTo( o2 );
            }
        };
        // 2. Lambdas
        Comparator<String> stringComparator1 = ( o1, o2 ) -> {return o1.compareTo( o2 );};
        Comparator<String> stringComparator2 = ( o1, o2 ) -> o1.compareTo( o2 );
        Comparator<String> stringComparator3 = String::compareTo;

//        strings.sort( stringComparator3 );
        strings.sort( String::compareTo );
        System.out.println( strings );

    }
}

interface CharToStringFunction {
    String map( char[] chars );
}
