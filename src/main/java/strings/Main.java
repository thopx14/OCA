package main.java.strings;

public class Main {

    public static void main( String[] args ) {
        NameGenerator s = new NameGenerator();
        StringBuilder sb = new StringBuilder();
        sb.append( s );
        sb.replace( 0, 0, "X" );
        sb.delete( sb.length() - 1, sb.length() );
        sb.append( "Test" );
        System.out.println( sb );

        // Hier wird die Aufgabe 'String-Silben' gelöst.
        System.out.println( s.generateName( 2 ) );
    }
}
