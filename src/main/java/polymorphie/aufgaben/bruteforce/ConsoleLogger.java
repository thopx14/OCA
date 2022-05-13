package main.java.polymorphie.aufgaben.bruteforce;

import java.util.Calendar;

/*
ConsolerLogger implementiert Loggable und überschreibt alle Methoden.
 */
public class ConsoleLogger implements Loggable {

    @Override
    public void log( Object loggingClass, String... texts ) {
        Calendar now = Calendar.getInstance();
        StringBuilder sb = new StringBuilder( texts.length );
        for ( String text : texts ) {
            sb.append( text );
        }
        System.out.printf( "%1$s:: %2$s: %3$tD: %3$tR ==> %4$s%n", loggingClass.getClass().getSimpleName(), this.getLoggerName(), now, sb );
    }

    /*
    Hier wird die default-Methode aus Loggable überschrieben.
    Die getLoggerName()-Methode muss aber nicht überschrieben werden, weil sie 'default' ist.
     */
    @Override
    public String getLoggerName() {
        return "ConsoleLogger";
    }
}
