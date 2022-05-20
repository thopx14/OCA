package main.java.polymorphie.interfaces.aufgaben;

import java.io.BufferedReader;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static void runExperiment( int x ) {
        System.out.println( "Ein Gedankenexperiment:" );
        System.out.println( "=======================" );

        System.out.printf( "Zuerst wird Ihre Zahl (%d) mit 2 multipliziert%n", x );
        //A1.
        IntOperation op1 = new Multiply( 2 );
        int result1 = op1.execute( x );
        System.out.printf( "Das Ergebnis ist: %d%n", result1 );

        System.out.printf( "Danach wird das Ergebnis der vorherigen Operation (%d) mit 5 multipliziert%n", result1 );
        //A2.
        IntOperation op2 = new Multiply( 5 );
        int result2 = op2.execute( result1 );
        System.out.printf( "Das Ergebnis ist: %d%n", result2 );

        System.out.printf( "Danach wird das Ergebnis der vorherigen Operation (%d) durch Ihre Zahl dividiert (%d)%n", result2, x );
        //A3.
        IntOperation op3 = new Divide( x );
        int result3 = op3.execute( result2 );
        System.out.printf( "Das Ergebnis ist: %d%n", result3 );

        System.out.printf( "Danach wird das Ergebnis der vorherigen Operation (%d) mit 7 subtrahiert%n", result3 );
        //A4.
        IntOperation op4 = new Subtract( 7 );
        int result4 = op4.execute( result3 );
        System.out.printf( "Das Ergebnis ist: %d%n", result4 );
        System.out.println( "=======================" );
        System.out.println( "Das Ergebnis ist immer 3!!" );
    }

    public static void main( String[] args ) {

        boolean run = true;
        while ( run ) {

            int x;
            while ( true ) {

                try {
                    System.out.print( "Bitte eine Zahl zwischen 1 - 10 eingeben: " );
                    x = new Scanner( System.in ).nextInt();
                    if ( x >= 1 && x <= 10 )
                        break;
                } catch ( InputMismatchException e ) {
//                    System.out.print( "Bitte eine Zahl zwischen 1 - 10 eingeben: " );
                }

            }
            runExperiment( x );
            System.out.print( "Noch ne Runde? (ja/nein) " );
            run = new Scanner( System.in ).nextLine().trim().equals( "ja" );
        }

        // A7.
        IntOperation[] ops = {
                new Add( 5 ), // addiert 5
                new ChangeSign(), // ändert das Vorzeichen
                new Multiply( 2 ), // mit 2 multiplizieren
                new Subtract( 3 )  // 3 subtrahieren
        };

        int result = 2;
        int startVal = result;
        for ( IntOperation op : ops ) {
            result = op.execute( result );
        }
        System.out.println( "=======================" );
        System.out.printf( "Endergebnis von A7 mit Eingabewert (%d): %d%n", startVal, result );

        //A8.
        IntOperation op = new Add( 5 )
                .andThen( new ChangeSign() )
                .andThen( new Multiply( 2 ) )
                .andThen( new Subtract( 3 ) );

        int result2 = op.execute( startVal );

        System.out.println( "=======================" );
        System.out.printf( "Endergebnis von A8 mit Eingabewert (%d): %d%n", startVal, result2 );

    }
}
