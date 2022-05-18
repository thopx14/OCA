package main.java.exceptions;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Throws {

    public static void main( String[] args ) {
        int i = multiplyExact( 2, 3 );
//        int j = multiplyExact2( 888888888, 999999 );
//        readAllLines( Paths.get( "Blablabla" ) );
        /*
        Exception wird hier unterdrückt und es wird einfach eine leere Liste zurückgegeben.
         */
        List<String> blubb = readAllLines2( Paths.get( "Blubb" ) );
        System.out.println( blubb.size() );
    }

    /**
     * Hier müsste eigentlich throws ArithmeticException stehen.
     * Da es aber eine 'unchecked Exception' ist, muss diese nicht explizit angegeben werden.
     */
    static int multiplyExact( int a, int b ) {
        return Math.multiplyExact( a, b );
    }

    static int multiplyExact2( int a, int b ) {
        try {
            /*
            Hier kann ein return stehen, weil im Fehlerfall 'throw e'
            ausgeführt wird. Ohne 'throw e' würde die Methode so nicht kompilieren.
            Dann müsste das return am Ende des 'try-catch' Blocks stehen.
             */
            return Math.multiplyExact( a, b );

        } catch ( ArithmeticException e ) {
            System.err.println( "Cannot multiply " + a + " X " + b + " because: " + e.getMessage() );
            /*
            Mit e.fillStackTrace();
            sieht der StackTrace dann so aus:
            Cannot multiply 888888888 X 999999 because: integer overflow
            Exception in thread "main" java.lang.ArithmeticException: integer overflow
          --->  at main.java.exceptions.Throws.multiplyExact2(Throws.java:25)
               	at main.java.exceptions.Throws.main(Throws.java:7)
             */
            e.fillInStackTrace();
            /*
            Ohne sieht es so aus:
            Cannot multiply 888888888 X 999999 because: integer overflow
            Exception in thread "main" java.lang.ArithmeticException: integer overflow
          --->  at java.base/java.lang.Math.multiplyExact(Math.java:964)
                at main.java.exceptions.Throws.multiplyExact2(Throws.java:20)
                at main.java.exceptions.Throws.main(Throws.java:7)

             */
            // rethrow e.
            throw e;
        }
    }

    /*
     * Hier wird die IOException 'umgepackt' in eine 'UncheckedIOException', die 'unchecked' ist
     * und nicht mit 'throws' angegeben werden muss.
     */
    static List<String> readAllLines( Path path ) {
        try {
            return Files.readAllLines( path, StandardCharsets.ISO_8859_1 );

        } catch ( IOException e ) {
            throw new UncheckedIOException( e );
//            throw e; <-- bei throw e müsste der Methodenrumpf 'throws IOException' angeben!
        }

    }

    static List<String> readAllLines2( Path path ) {
        List<String> strings = null;
        try {
            strings = Files.readAllLines( path, StandardCharsets.ISO_8859_1 );

        } catch ( IOException e ) {
            // Ignore!
            // In case an IOException occurred, initialize strings to prevent returning 'null'.
            strings = new ArrayList<String>();
        }
        return strings;
    }
}
