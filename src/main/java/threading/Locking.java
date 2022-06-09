package main.java.threading;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locking {
    public static void main( String[] args ) {

        StringBuilder sb = new StringBuilder();

        Runnable r1 = () -> {
            String nowString = LocalTime.now().toString();

            for ( int i = 0; i < nowString.length(); i++ ) {
                sb.append( nowString.charAt( i ) );
                /*
                    Die Ausgabe ist Kauderwelsch, da alle in dieselbe Datenstruktur
                    schreiben, ohne Synchronisation!

                    11115:16:55.879305:16:55.8799505:16:55.87
                    11115:16:55.879305:16:55.8799505:16:55.879
                    11115:16:55.879305:16:55.8799505:16:55.8799
                 */
                System.out.println( sb );
            }
        };

        // Der Lock muss zwingend vor dem eigentlichen Runnable deklariert werden!
        // Ansonsten hat jedes Runnable sein eigenes Lock-Objekt, was wiederrum dafür sorgt,
        // dass der Lock-Mechanismus nicht funktioniert!
        Lock lock = new ReentrantLock();

        Runnable r2 = () -> {
            String nowString = LocalTime.now().toString();
            /*
                Hier sollte dringend ein try-finally-Block stehen, da
                beim Auftreten einer Exception, der Lock nicht mehr freigegeben werden kann.
             */
            try {
                lock.lock();
                ///////////////////////////////////////////////////
                // Kritischer Bereich!
                for ( int i = 0; i < nowString.length(); i++ ) {
                    sb.append( nowString.charAt( i ) );
                    Thread.sleep( 100 );

                    /*
                        Jetzt sieht es geordneter aus:
                            15:30:43.76701515:30:43.76710415:30:43.76707315:30:43.7670
                            15:30:43.76701515:30:43.76710415:30:43.76707315:30:43.76709
                            15:30:43.76701515:30:43.76710415:30:43.76707315:30:43.767099
                     */
                    System.out.println( sb );
                    ///////////////////////////////////////////////////
                }
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute( r1 );
//        executorService.execute( r1 );
//        executorService.execute( r1 );
//        executorService.execute( r1 );
        executorService.execute( r2 );
        executorService.execute( r2 );
        executorService.execute( r2 );
        executorService.execute( r2 );
        executorService.shutdown();
    }
}

