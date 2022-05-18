package main.java.polymorphie.aufgaben.bruteforce;

import java.util.Calendar;

/*
ConsolerLogger implementiert Loggable und überschreibt alle Methoden.
 */
public class ConsoleLogger implements Loggable {

    /*
    Hier muss definitiv 'public' stehen, da in einem Interface zwingend alle Methoden public abstract sind.
    Auch wenn es nicht explizit dran steht! Sollte die Oberklasse eine Exception werfen,
    so muss die implementierende Klasse nicht unbedingt 'throws' angeben. Allerdings muss beim Aufruf
    der nutzenden Klasse dann ein try - catch erfolgen. Ebenso dann die überschriebene Methode eine Unterklasse
    werfen (als die im Interface mit throws deklarierte). Man kann aber keine Klasse, die weiter oben in der
    Vererbungshierarchie ist werfen - also z.B. kein Throwable, oder Exception (wenn im Interface
     etwas 'höheres' geworfen wird)
     */
    @Override
    // Kann auch so dort stehen. Wenn log(..) aus Loggable Exception wirft, kann
    // ConsoleLogger auch eine Unterklasse werfen (z.B. IOException).
//    public void log( Object loggingClass, String... texts ) throws IOException {
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
