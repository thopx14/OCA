package main.java.strings;

import java.util.Scanner;

public class ScannerTest {

    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        System.out.print( "Bitte Namen eingeben: " );
        String name = sc.nextLine();
        System.out.println( name );
        
    }

}
