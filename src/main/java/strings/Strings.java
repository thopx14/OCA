package main.java.strings;

public class Strings {
    public static void main( String[] args ) {

        // Zwei neue Objekte auf dem String-Pool, die beim Laden der Klasse zum String-
        // Pool hinzugefügt werden. Im String-Pool stehen nur Literale!
        String t = "mo";
        String a = "do";

        // Ein komplett neuer String wird auf dem Heap erzeugt.
        // Dieser String ist nicht im String-Pool enthalten.
        String n = new String( "mo" );

        // Hier wird ebenfalls ein neuer String erzeugt (Konkatenation von zwei Strings)
        // liefert einen neuen String zurück. Strings sind immutable.
        String neu = a + t;

        reverse( "Heute ist Freitag!" );
        System.out.println();
        reverse( "Das ist ein Test" );
        System.out.println();

        /*
         * Ein Beispiel für Referenzen mit Strings
         * ----------------------------------------
         *  ----------
         * |    s1    |  --------->  "Java"
         *  ----------
         *
         *  ----------
         * |    s2    |  --------->  s1 ("Java")
         *  ----------
         *
         *  ----------
         * |    s1    |  --------->  "Java ist toll" (Ein neues String-Objekt wird erzeugt)
         *  ----------
         */
        String s1 = "Java";
        String s2 = s1; // "Java"

        s1 += " ist toll"; // Neuer String mit "Java ist toll".
        System.out.println( "s2 = " + s2 ); //Java
    }

    static void reverse( String s ) {
        // String rückwärts ausgeben
        for ( int i = s.length() - 1; i >= 0; i-- ) {
            System.out.print( s.charAt( i ) );
        }

    }
}
