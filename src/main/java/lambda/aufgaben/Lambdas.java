package main.java.lambda.aufgaben;

import java.util.ArrayList;
import java.util.List;

public class Lambdas {
    public static void main( String[] args ) {

        /*
            A1:
         */
        IntOperation op1 = Integer::sum;                    // Kann Summe bilden
        System.out.println( op1.execute( 2, 3 ) );      // 5

        IntOperation op3 = Math::max;                   // Kann den größeren Wert ermitteln
//        IntOperation op3 = (x,y ) -> Math.max(x,y);  // Langversion
        System.out.println( op3.execute( - 6, 17 ) ); // 17

        /*
            A2:
         */
        List<String> strings = new ArrayList<>();
        strings.add( "Blau" );
        strings.add( "Beere" );
        strings.add( "Hans" );
        strings.add( "Olaf" );
        strings.add( "DuDa" );

//        public int compare( String o1, String o2 )
//        strings.sort((s1, s2) -> s1.compareTo( s2 )); // Langversion
        strings.sort( String::compareTo );                 // Kurzversion
        System.out.println( strings );

        /*
            A3:
         */

        List<Integer> list1 = new ArrayList<>();
        list1.add( 12 );
        list1.add( 44 );
        list1.add( 42 );

        List<Integer> list2 = new ArrayList<>();
        list2.add( 22 );
        list2.add( 25 );
        list2.add( 99 );

        ListPair combiner = ( l1, l2 ) -> {
            l1.addAll( l2 );
            return new ArrayList<>( l1 );
        }; // hier die Lambda-Funktion
        List<Integer> list3 = combiner.accept( list1, list2 );
        //list3 hat alle Elemente aus list1 und list2
        System.out.println( list3 );

        /*
            A4:
         */
        ArrayList<CPU> cpus = new ArrayList<>();
        cpus.add( new CPU( 32, "AMD" ) );
        cpus.add( new CPU( 16, "Intel" ) );
        cpus.add( new CPU( 64, "Apple" ) );
        // void accept(T t)
//        cpus.forEach( c -> {System.out.println( c );} );    // Langform
        cpus.forEach( System.out::println );                // Kurzform
    }
}

interface IntOperation {
    int execute( int x, int y );
}

interface ListPair {
    List<Integer> accept( List<Integer> list1, List<Integer> list2 );
}

class CPU {
    int anzahlKerne;
    String hersteller;

    public CPU( int anzahlKerne, String hersteller ) {
        this.anzahlKerne = anzahlKerne;
        this.hersteller = hersteller;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "anzahlKerne=" + anzahlKerne +
                ", hersteller='" + hersteller + '\'' +
                '}';
    }
}
