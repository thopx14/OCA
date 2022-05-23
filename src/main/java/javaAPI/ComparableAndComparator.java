package main.java.javaAPI;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparator {
    public static void main( String[] args ) {

        /*
         * Test mit Strings
         */
        System.out.println( "abc".compareTo( "def" ) ); // <0
        System.out.println( "xyz".compareTo( "def" ) ); // >0
        System.out.println( "abc".compareTo( "abc" ) ); // =0

        Radio r1 = new Radio();
        r1.frequency = 103.8;

        Radio r2 = new Radio();
        r2.frequency = 99.7;

        System.out.println( r1.equals( r2 ) ); //false
        System.out.println( r1.compareTo( r2 ) ); // >0
        System.out.println( r2.compareTo( r1 ) ); // <0

        r2.frequency = 103.8;
        System.out.println( r2.compareTo( r1 ) ); // =0

        r2.frequency = 99.7;

        List<Radio> radios = new ArrayList<>();
        radios.add( r1 );
        radios.add( r2 );
        System.out.println( radios );
        radios.sort( new RadioComparator() );
        Collections.sort( radios );
        System.out.println( radios );

        // Diese Methode nutzt compareTo aus der 'Radio' implementierung.
        System.out.println( Collections.max( radios ) );
        // Diese Methode nutzt compareTo aus der 'RadioComparator' implementierung.
        System.out.println( Collections.max( radios, new RadioComparator() ) );

        System.out.println( LocalTime.now() );
        System.out.println( LocalTime.now().plusHours( 1 ) );
        System.out.println( LocalTime.now().minusHours( 1 ) );

        List<LocalTime> times = new ArrayList<>();
        times.add( LocalTime.now() );
        times.add( LocalTime.now().plusHours( 1 ) );
        times.add( LocalTime.now().minusHours( 1 ) );

        // Mit Hilfe von Collections.sort kann alles sortiert werden, was Comparable<T> implementiert!
        Collections.sort( times );
        System.out.println( times );

    }
}

class Radio implements Comparable<Radio> {
    double frequency;

    @Override
    public String toString() {
        return "Radio{" +
                "frequency=" + frequency +
                '}';
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        Radio radio = ( Radio ) o;

        return Double.compare( radio.frequency, frequency ) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits( frequency );
        return ( int ) ( temp ^ ( temp >>> 32 ) );
    }

    @Override
    public int compareTo( Radio o ) {
        /*
        So wird verglichen.
         */
//        if(frequency > o.frequency)
//            return +1;
//        if(frequency < o.frequency)
//            return -1;
        return Double.compare( frequency, o.frequency );
    }
}

/*
 * Ein Comparator<T> wird z.B. für Collections verwendet, um diese zu sortieren.
 */
class RadioComparator implements Comparator<Radio> {

    @Override
    public int compare( Radio o1, Radio o2 ) {
        return Double.compare( o1.frequency, o2.frequency );
    }
}
