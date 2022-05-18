package main.java.polymorphie.aufgaben.bruteforce;

public interface Loggable {

    /*
     Eigentlich stünde hier 'public abstract' void log(...);
     Wird eine Exception geworfen, so muss diese in der implementierenden Klasse nicht zwingend,
     mit 'throws' angegeben werden. Der aufrufende Code muss die Exception aber trotzdem behandeln!

     */
    // z.B. so:
//    void log( Object loggingClass, String... texts ) throws Exception;
    void log( Object loggingClass, String... texts );

    /* default wird hier implementiert, kann aber auch von Unterklassen überschrieben werden.
       Muss aber nicht!
    */
    default String getLoggerName() {
        return "Ich bin eigentlich kein Logger ;-)";
    }
}
