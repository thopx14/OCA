package main.java.polymorphie.interfaces.aufgaben;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

class Person implements Comparable<Person> {
    private final String vorname;
    private final String nachname;
    private final LocalDate geburtstag;

    public Person( String vorname, String nachname, LocalDate geburtstag ) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtstag = geburtstag;
    }

    @Override
    public String toString() {
        return vorname + " " + nachname + " " + geburtstag.format( DateTimeFormatter.ofLocalizedDate( FormatStyle.MEDIUM ) );
    }

    @Override
    public int compareTo( Person o ) {
        int res = nachname.compareTo( o.nachname );
        if ( res == 0 ) { // Nachname ist gleich.
            res = vorname.compareTo( o.vorname ); // Vergleiche Vorname.
            if ( res == 0 ) { // Vorname auch gleich.
                res = geburtstag.compareTo( o.geburtstag );
            }
        }
        return res;
    }
}

public class PersonTester {
    public static void main( String[] args ) {

        List<Person> people = new ArrayList<>();
        people.add( new Person( "Paul", "Smith", LocalDate.of( 1960, Month.APRIL, 4 ) ) );
        people.add( new Person( "Paul", "Black", LocalDate.of( 1985, Month.JANUARY, 1 ) ) );
        people.add( new Person( "John", "Smith", LocalDate.of( 1920, Month.AUGUST, 15 ) ) );
        people.add( new Person( "John", "Smith", LocalDate.of( 1999, Month.SEPTEMBER, 15 ) ) );
        people.add( new Person( "John", "Black", LocalDate.of( 1899, Month.JULY, 9 ) ) );
        people.add( new Person( "John", "Black", LocalDate.of( 1722, Month.JULY, 28 ) ) );

        // A2:
        printArray( people, "Ohne Sortierung" );
        System.out.println();

        // A3:
        Collections.sort( people );
        printArray( people, "Mit Sortierung nach Nachnamen und Vornamen" );

        System.out.println();
        // A4:
        int foundIndex = Collections.binarySearch( people,
                new Person( "John", "Black", LocalDate.of( 1899, Month.JULY, 9 ) ) );

        if ( foundIndex >= 0 ) {
            System.out.println( "John Black gefunden: " );
            System.out.println( people.get( foundIndex ) );
        }

        System.out.println();

        // A5:
        people.sort( ( p1, p2 ) -> p2.compareTo( p1 ) ); // Kann mit Comparator.reversedOrder ersetzt werden.
        printArray( people, "Absteigend sortiert" );

        // A6:
        foundIndex = Collections.binarySearch( people,
                new Person( "Paul", "Smith", LocalDate.of( 1960, Month.APRIL, 4 ) ), ( p1, p2 ) -> p2.compareTo( p1 ) );
        // Kann mit Comparator.reversedOrder ersetzt werden.

        System.out.println();
        if ( foundIndex >= 0 ) {
            System.out.println( "Paul Smith gefunden: " );
            System.out.println( people.get( foundIndex ) );
        }

    }

//    static <T> void printArray( List<T> l, String title ) {
//        System.out.println( title + ":" );
//        for ( T t : l ) {
//            System.out.println( t );
//        }
//    }

    // Geht auch so:
    static void printArray( List<?> l, String title ) {
        System.out.println( title + ":" );
        l.forEach( System.out::println );
    }
}
