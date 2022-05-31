package main.java.generics;

import java.io.Serializable;

public class GenericsBoundedTypes {

    /*
        Hier kann man Typen übergeben, die CharSequence und Serializable implementieren.
     */
    static <T extends CharSequence & Serializable> int randomLen( T first, T second ) {
        return Math.random() > 0.5 ? first.length() : second.length();
    }

    public static void main( String[] args ) {
        System.out.println( randomLen( "Hallo Welt", new StringBuilder() ) );
//        System.out.println( randomLen( "Huhu", 122.0 ) ); // geht nicht!
    }
}
