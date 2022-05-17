package main.java.strings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class StringBuilderUndStringBuffer {
    public static void main( String[] args ) throws IOException {
        /*
        StringBuilder und StringBuffer sind API identisch, allerdings ist StringBuffer veraltet.
        In der StringBuffer-Klasse sind alle Methoden synchronisiert.
         */
        StringBuilder sb = new StringBuilder();
//        StringBuffer sb = new StringBuffer();

        // Heute ist Montag
        sb.append( "Heute ist Montag" ).replace( 10, 17, "Dienstag" );
        System.out.println( sb );                               //Heute ist Dienstag
        System.out.println( sb.reverse() );                     //gatsneiD tsi etueH
        System.out.println( sb.reverse().delete( 0, 6 ) );      //ist Dienstag
        sb.insert( 3, " nicht" );
        System.out.println( sb );                               // ist nicht Dienstag

        StringBuilder passwordList = new StringBuilder();
        String passwords = "passwords.txt";
        try ( BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                StringBuilderUndStringBuffer.class.getResourceAsStream(
                                        passwords ) ) ) ) ) {

            String text = "";
            while ( text != null ) {
                text = reader.readLine();
                if ( text != null ) {
                    passwordList.append( text ).append( "\n" );
                }
            }
        }
        
        System.out.println( "Passwordlist:" );
        System.out.println( "==================" );
        shufflePasswords( passwordList, "=!n/,\\<>;'-\"" );
        System.out.println( passwordList );
    }

    // int randomNumber = ( int ) ( from + Math.round( Math.random() * ( to - from ) ) );
    static void shufflePasswords( StringBuilder sb, String exclude ) {
        char from = '!';
        char to = '~';
        for ( int i = 0; i < sb.length(); i++ ) {
            // Zeilenumbruch nicht ändern!
            if ( sb.charAt( i ) != '\n' ) {

                char randomChar = ( char ) ( from + Math.round( Math.random() * ( to - from ) ) );
                // Sonderzeichen exkludieren. Nur Klein- und Großbuchstaben erzeugen!
                while ( exclude.contains( String.valueOf( randomChar ) ) ) {
                    // Nächste Runde...
                    randomChar = ( char ) ( from + Math.round( Math.random() * ( to - from ) ) );
                }
                sb.replace( i, i + 1, String.valueOf( randomChar ) );
            }
        }
    }

}
