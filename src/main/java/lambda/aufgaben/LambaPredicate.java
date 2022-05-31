package main.java.lambda.aufgaben;

import java.util.Arrays;
import java.util.function.Predicate;

public class LambaPredicate {
    public static void main( String[] args ) {

        Integer[] arr = {23, 24, 55, 99, 101, 1024, - 22, - 99, 0};
        printIf( arr, i -> i >= 0 );
        System.out.println( "================" );
        printIf( arr, i -> i % 2 == 0 );
        System.out.println( "================" );
        printIf( arr, i -> i % 2 == 0 && i >= 0 );
        Predicate<Integer> isPositive = i -> i >= 0;
        Predicate<Integer> isEven = i -> i % 2 == 0;
        Predicate<Integer> combined = isPositive.and( isEven ); // Kombinieren von zwei Predicates.
        System.out.println( "================" );
        printIf( arr, combined );
    }

    static void printIf( Integer[] arr, Predicate<Integer> p ) {
        for ( Integer integer : arr ) {
            if ( p.test( integer ) ) {
                System.out.println( integer );
            }
        }
    }
}
