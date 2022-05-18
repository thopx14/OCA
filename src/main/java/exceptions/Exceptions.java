package main.java.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Exceptions {
    public static void main( String[] args ) {
        
        try {
            Path path = Paths.get( "numbers.txt" );
            List<String> strings = Files.readAllLines( path );
            for ( String string : strings ) {
                int number = Integer.parseInt( string );
            }
        } catch ( IOException | NumberFormatException e ) {
            System.err.println( e.getMessage() );
        }

    }
}
