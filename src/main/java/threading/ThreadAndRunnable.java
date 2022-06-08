package main.java.threading;

public class ThreadAndRunnable {
    public static void main( String[] args ) {
        System.out.println( Thread.currentThread().getName() ); //main
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println( Thread.currentThread().getName() + " running ..." );
            }
        };

        Runnable runnable2 = () -> {
            System.out.println( Thread.currentThread().getName() + " running ..." );
        };

        Runnable runnable3 = () -> {
            System.out.println( 1 / 0 );
            System.out.println( Thread.currentThread().getName() + " running ..." );
        };

        new Thread( runnable3, "runnable3" ).start();
        /*
            Ausgabe:
            main
            Exception in thread "runnable3" java.lang.ArithmeticException: / by zero
                at main.java.threading.ThreadAndRunnable.lambda$main$1(ThreadAndRunnable.java:18)
                at java.base/java.lang.Thread.run(Thread.java:833)
            runnable2 running ...
            runnable1 running ...

            Es wird nur der Thread beendet, der die Exception geworfen hat. Alle anderen Threads laufen
            bis zu deren Ende.
         */
        Thread t1 = new Thread( runnable1, "runnable1" );
        t1.start(); //runnable1 running ...
        Thread t2 = new Thread( runnable2, "runnable2" );
        t2.start(); // runnable2 running ...

        // Kurzschreibweise
        new Thread( () -> {System.out.println( "Huhu" );}, "Printthread" ).start();
    }
}
