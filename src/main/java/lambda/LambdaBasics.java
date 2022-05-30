package main.java.lambda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaBasics {
    public static void main( String[] args ) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add( "Hallo" );
        strings.add( "Welt" );
        strings.add( "" );
        System.out.println( strings ); //[Hallo, Welt, ]
        strings.removeIf( s -> s.isEmpty() );

        // Das selbe wie oben: s -> s.isEmpty()
        Predicate<String> removeIfPredicate = new Predicate<String>() {
            @Override
            public boolean test( String s ) {
                return s.isEmpty();
            }
        };

        // Das selbe wie oben: s -> s.isEmpty()
        /*
            Lambdas funktionieren nur, wenn die Annotation @FunctionalInterface gesetzt ist.
            Das bedeutet, dass die Schnittstelle oder abstrakte Klasse nur eine abstrakte Methode hat,
            die überschrieben werden muss. Bei Predicate wäre das z.B.:
            public interface Predicate<T> {
            ...
            ---> boolean test(T t);
            ...
            }

         */
        strings.removeIf( removeIfPredicate );

        System.out.println( strings ); // [Hallo, Welt]

        Consumer<String> stringConsumer = new Consumer() {

            @Override
            public void accept( Object o ) {
                System.out.println( o );
            }
        };

        strings.add( "John" );
//        strings.forEach( stringConsumer );

        /*
            Lange Schreibweise, passend zur Signatur:
            --> public void accept( Object o )
         */
        strings.forEach( ( String s ) -> {System.out.println( s );} );
        // Kurzschreibweise, statische Methodenreferenz
        strings.forEach( System.out::println );

        /*
            Kurzschreibweise
         */
        strings.forEach( s -> System.out.println( s ) );
        // Kurzschreibweise, statische Methodenreferenz
        strings.forEach( System.out::println );


         /*
         Die Schreibweise kurz erklärt:

         interface Runnable    { void run(); }
         interface ActionListener { void actionPerformed(ActionEvent e); }
         interface Supplier<T>    { T get(); }
         interface Consumer<T>    { void accept(T t); }
         interface Comparator<T>  { int compare(T o1, T o2); }
         */
        // Rückgabe 'void', also () und kein Ausdruck im Block.
        Runnable runnable = () -> {};

        // Parameter 'ActionEvent e' und Rückgabe 'void'.
        ActionListener listener = ( ActionEvent e ) -> {};

        // Parameter vom Typ 'Point' und Rückgabe 'void'
        Consumer<Point> consumer = ( Point t ) -> {};

        // 2 Parameter vom Typ 'Rectangle' und Rückgabe 'int'.
        Comparator<Rectangle> comparator = ( Rectangle o1, Rectangle o2 ) -> {return 0;};
        // ... oder kürzer:
        Comparator<Rectangle> comparator2 = ( Rectangle o1, Rectangle o2 ) -> 0;
    }
}
