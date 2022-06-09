package main.java.threading;

import java.time.LocalTime;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main( String[] args ) {
        /*
            Hier wird ein ExecutorService aufgebaut und ein Callable übergeben
            (siehe FactorialCallable). Damit wird
         */
        ExecutorService service = Executors.newCachedThreadPool();
        // submit kann sowohl mit Runnable als auch Callable gefüttert werden.
        Future<Integer> future = service.submit( new FactorialCallable( 6 ) );
        // ... hier geht's ganz normal weiter

        System.out.println( LocalTime.now() );

        try {

            System.out.println( future.get() ); // Wartet so lange bis ein Ergebnis da ist!
            System.out.println( LocalTime.now() );

        } catch ( InterruptedException | ExecutionException | IllegalArgumentException e ) {
            // Shutdown service, falls eine Exception geworfen wurde
            service.shutdown();
            throw new RuntimeException( e );
        }

        service.shutdown();

    }
}

class FactorialCallable implements Callable<Integer> {

    private final int factorial;

    public FactorialCallable( int facultyOf ) {
        this.factorial = facultyOf;
    }

    private int factorial( int n ) throws InterruptedException {
        Thread.sleep( 2000 );
        if ( n >= 15 )
            throw new IllegalArgumentException( "n (" + n + ") is too big! 15 is max!" );

        if ( n <= 1 ) {
            return n;
        }
        return factorial( n - 1 ) * n;
    }

    // Ruft factorial auf und gibt dabei auch etwas zurück.
    // Das Ergebnis kann dann mit future.get() abgefragt werden.
    @Override
    public Integer call() throws Exception {
        return factorial( factorial );
    }
}
