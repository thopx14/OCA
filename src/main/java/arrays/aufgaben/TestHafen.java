package main.java.arrays.aufgaben;

public class TestHafen {

    public static void main( String[] args ) {
        Hafen testHafen = new Hafen("Hamburg");
        System.out.println( "========================" );
        System.out.println( "Ein paar Schiffe hinzufügen" );
        System.out.println( "========================" );

        try {
            for ( int i = 0; i < 96; i++ ) {
                testHafen.addSchiff( new Schiff(testHafen) );
            }

            testHafen.addSchiff( new Schiff( "Gorch Fok", testHafen ) );
            testHafen.addSchiff( new Schiff( "Altona 1", testHafen ) );
            testHafen.addSchiff( new Schiff( "Altona 2", testHafen ) );
            testHafen.addSchiff( new Schiff( "Klaus Bärbel 12", testHafen ) );

            System.out.println( testHafen );

        } catch ( HafenVollException e ) {
            System.err.println( e.getMessage() );
        }
    }
}
