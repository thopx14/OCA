package main.java.strings;

import java.text.SimpleDateFormat;

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
        String beforeStrConcatStr;
        String beforeSbConcatStr;
        String afterStrConcatStr;
        String afterSbConcatStr;

        int cycles = 100_000;

        SimpleDateFormat sdf = new SimpleDateFormat( "hh:mm:ss:SSS" );

        beforeStrConcat = System.currentTimeMillis();
        beforeStrConcatStr = sdf.format( beforeStrConcat );

        for ( int i = 0; i < cycles; i++ ) {
            out += s1 + s2 + s3;
        }

        afterStrConcat = System.currentTimeMillis();
        afterStrConcatStr = sdf.format( afterStrConcat );

        StringBuilder sb = new StringBuilder();

        beforeSbConcat = System.currentTimeMillis();
        beforeSbConcatStr = sdf.format( beforeSbConcat );

        for ( int i = 0; i < cycles; i++ ) {
            sb.append( s1 ).append( s2 ).append( s3 );
        }

        afterSbConcat = System.currentTimeMillis();
        afterSbConcatStr = sdf.format( afterSbConcat );

        System.out.printf( "Results for %d cycles:%n", cycles );
        System.out.println( "=========================" );
        System.out.printf( "String concat duration: %dms%n", afterStrConcat - beforeStrConcat );
        System.out.printf( "StringBuilder append duration: %dms%n", afterSbConcat - beforeSbConcat );
        System.out.printf( "String length: %d%n", out.length() );
        System.out.printf( "StringBuilder length: %d%n", sb.length() );
        System.out.println( "Duration details:" );
        System.out.println( "=====================" );
        System.out.printf( "String concat: %s ... %s%n", beforeStrConcatStr, afterStrConcatStr );
        System.out.printf( "StringBuilder append: %s ... %s%n", beforeSbConcatStr, afterSbConcatStr );

    }
}
