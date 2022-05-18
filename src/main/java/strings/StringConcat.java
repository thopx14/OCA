package main.java.strings;

import java.util.concurrent.TimeUnit;

/*
Testing StringBuilder vs. String concatenation.
 */
public class StringConcat {
    public static void main( String[] args ) {

        String s1 = "Hello";
        String s2 = " ";
        String s3 = "Welt";
        String out = "";

        long beforeStrConcat;
        long beforeSbConcat;

        long afterStrConcat;
        long afterSbConcat;

        int cycles = 10_000;

        beforeStrConcat = System.nanoTime();

        for ( int i = 0; i < cycles; i++ ) {
            out += s1 + s2 + s3;
        }

        afterStrConcat = System.nanoTime();

        StringBuilder sb = new StringBuilder();

        beforeSbConcat = System.nanoTime();

        for ( int i = 0; i < cycles; i++ ) {
            sb.append( s1 ).append( s2 ).append( s3 );
        }

        afterSbConcat = System.nanoTime();

        System.out.printf( "Results for %d cycles:%n", cycles );
        System.out.println( "=========================" );
        System.out.printf( "String concat duration: %dms%n", TimeUnit.NANOSECONDS.toMillis( afterStrConcat - beforeStrConcat ) );
        System.out.printf( "StringBuilder append duration: %dms%n", TimeUnit.NANOSECONDS.toMillis( afterSbConcat - beforeSbConcat ) );
        System.out.printf( "String length: %d%n", out.length() );
        System.out.printf( "StringBuilder length: %d%n", sb.length() );

    }
}
