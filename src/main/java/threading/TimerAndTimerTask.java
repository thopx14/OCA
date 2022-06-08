package main.java.threading;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerAndTimerTask {
    public static void main( String[] args ) {
        class MyTimerTask extends TimerTask {

            @Override
            public void run() {
                System.out.println( "MyTimerTask: " + LocalTime.now() );
            }
        }

        Timer timer = new Timer();
        /*
             Führt die run() Methode in MyTimerTask aus, mit einem period von 2.000 ms.
             Das heißt, dass alle 2 Sekunden ein neuer MyTimerTask erzeugt wird.
        */
//        timer.schedule( new MyTimerTask(), 2000 /* ms */ );
        /*
             Führt die run() Methode in MyTimerTask aus, mit einem Delay von 2.000 ms, siehe oben.
             Allerdings startet der Thread sofort und nicht erst nach einer Verzögerung (periode).
             Hier wird dann zuerst "MyTimerTask: ..." ausgegeben und danach:
             "Thread main: ..."
        */
//        timer.schedule( new MyTimerTask(), 0, 2000 /* ms */ );
        /*
            Ähnlich wie "schedule()", aber der Thread läuft nur exakt 2000 ms und danach wird ein
            neuer Thread gestartet.
         */
        timer.scheduleAtFixedRate( new MyTimerTask(), 0, 2000 /* ms */ );
        System.out.println( "Thread main: " + LocalTime.now() );
    }
}
