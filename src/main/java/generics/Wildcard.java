package main.java.generics;

import java.util.*;

public class Wildcard {
    public static void main( String[] args ) {

        List<Double> numbers = new ArrayList<>();
        numbers.add( 12.0 );
        numbers.add( 120.0 );
        numbers.add( 15.0 );
        System.out.println( sum( numbers ) );

//        List<Number> numbers2 = numbers; // Das geht nicht! Es existiert keine Hierarchie zwischen den Typen.

        ArrayList<String> strings = new ArrayList<>();
        strings.add( "Hallo" );
        strings.add( "Welt" );
        Comparator<Object> comparator = new Comparator<>() {

            @Override
            public int compare( Object o1, Object o2 ) {
                return 0;
            }
        };

        /*
            Das funktioniert, da Object eine Oberklasse von String ist!
         */
        // public void sort(Comparator<? super E> c)
        strings.sort( comparator );

        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare( Integer o1, Integer o2 ) {
                return 0;
            }
        };

        /*
            Das funktioniert nicht, da der Comparator ein Geschwister-Typ ist!
         */
//        strings.sort( comparator1 );
    }

    /*
    Hier habe ich eine Funktion, die T deklariert. Mit T kann ich dann innerhalb der
    Funktion Variablen deklarieren und damit 'arbeiten'.
   */
//  static <T extends Number> double sum( List<T> numbers ) {
//    double sum = 0;
//    for ( T number : numbers ) {
//      sum += number.doubleValue();
//    }
//    return sum;
//  }

    /*
      Hier habe ich kein T oder U usw. mehr. Das setze ich ein, wenn ich z.B. innerhalb der Funktion
      keinen Zugriff auf T haben muss. Mir ist dann der Typ egal - hauptsache es ist numbers enthält eine List
      von Typen die Numbers erweitert.
     */
    static double sum( List<? extends Number> numbers ) {
        double sum = 0;
        for ( Number number : numbers ) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
