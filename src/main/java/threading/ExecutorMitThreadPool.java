package main.java.threading;

import java.util.concurrent.*;

public class ExecutorMitThreadPool {
    public static void main( String[] args ) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = () -> {
            System.out.println( "Runnable 1: " + Thread.currentThread() );
        };
        executorService.execute( runnable ); // Hallo von: Thread[pool-1-thread-1,5,main]
        // Der obige Thread lebt noch genau 60 Sekunden, nachdem er sich beendet hat.
        // Anschließend wird er vom executorService beendet.

        /*
            Hallo von: Thread[pool-1-thread-3,5,main]
            Hallo von: Thread[pool-1-thread-1,5,main]
            Hallo von: Thread[pool-1-thread-5,5,main]
            Hallo von: Thread[pool-1-thread-2,5,main]
         */
        executorService.execute( runnable );
        executorService.execute( runnable );
        executorService.execute( runnable );
        executorService.execute( runnable );
        // Möchte man den executorService beenden, so kann man die Methode shutdown() aufrufen.
        executorService.shutdown(); // Wartet keine 60 Sekunden nach Ende des letzten Threads.

        Runnable r2 = () -> {
            System.out.println( "Runnable 2 " + Thread.currentThread() );
        };
        /*
            Hier erhält man einen neuen ScheduledThreadPool, mit dessen Hilfe man, ähnlich wie beim TimerTask, die
            Ausführung steuern kann. "corePoolSize" legt fest, wie viele Threads zu Beginn vorgehalten werden sollen.
            Wenn der Wert "0" beträgt, dann existieren im Moment der Erzeugung des Objektes keine Threads. Diese kommen
            dann Stück für Stück dazu, wenn man den ScheduledThreadPool "füttert".
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool( 0 );
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate( r2, 0, 2, TimeUnit.SECONDS );
        Thread.sleep( 2000 );
        // mayInterruptIfRunning wird auf "false" gesetzt, weil im Runnable nicht auf isInterrupted() geprüft wird!
        scheduledFuture.cancel( false );
    }
}
