package main.java.threading;

import java.util.concurrent.TimeUnit;

public class SleepingAndTimeUnts {
    public static void main( String[] args ) {
        // Den aktuell laufenden Thread schlafen legen:
        try {
            // Die sleep Methode wirft eine InterruptedException,
            // die vom Typ 'checked exceptions' ist und somit abgefangen werden muss.
            Thread.sleep( 2000 /* ms */ );
            // Macht dasselbe wie oben. Die Methode ruft Thread.sleep() auf und rechnet vorher
            // Sekunden in Millisekunden um.
            TimeUnit.SECONDS.sleep( 1 );

        } catch ( InterruptedException e ) {
            throw new RuntimeException( e );
        }

        // Praktisch!
        System.out.println( TimeUnit.DAYS.toSeconds( 2 ) ); // 172800
        System.out.println( TimeUnit.SECONDS.toMillis( 2 ) ); // 2000
    }
}
