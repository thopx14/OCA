package main.java.threading;

import java.time.LocalTime;

public class Interrupt {
    public static void main( String[] args ) throws InterruptedException {
        Runnable r1 = () -> {
            // Prüft, ob das "interrupt Flag" gesetzt wurde. Also ob von Außen jemand
            // den Thread abbrechen möchte.
            while ( ! Thread.currentThread().isInterrupted() ) {
                System.out.println( "r1: " + LocalTime.now() );

                try {
                    Thread.sleep( 500 );

                } catch ( InterruptedException e ) {
                    // Falls während des "sleep()" Aufrufs ein Interrupt kommt,
                    // dann muss das "interrupt Flag" erneut gesetzt werden, da
                    // es sonst hier im Catch-Block automatisch gelöscht wird.
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread thread = new Thread( r1 );
        thread.start();
        // interrupt() setzt intern ein Flag, das der jeweilige Thread
        // aber berücksichtigen muss. Ignoriert er das Flag, so passiert nix (siehe unten)!
        Thread.sleep( 2000 );
        thread.interrupt();

        Runnable r2 = () -> {
            while ( true ) {
                System.out.println( "r2: " + LocalTime.now() );
            }
        };

//        Thread thread2 = new Thread( r2 );
//        thread2.start();
//        thread2.interrupt(); // Hier passiert nix!
    }
}
