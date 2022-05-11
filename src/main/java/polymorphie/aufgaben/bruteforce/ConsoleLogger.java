package main.java.polymorphie.aufgaben.bruteforce;

import java.util.Calendar;

public class ConsoleLogger extends Logging {

    public ConsoleLogger() {
        super( "ConsoleLogger " );
    }

    @Override
    public void log( Object loggingClass, String... texts ) {
        Calendar now = Calendar.getInstance();
        StringBuilder sb = new StringBuilder( texts.length );
        for ( String text : texts ) {
            sb.append( text );
        }
        System.out.printf( "%1$s:: %2$s: %3$tD: %3$tR ==> %4$s%n", loggingClass.getClass().getSimpleName(), this.getLoggerName(), now, sb );
    }
}
