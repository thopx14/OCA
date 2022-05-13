package main.java.polymorphie.aufgaben.bruteforce;

public interface Loggable {

    /*
     Eigentlich stünde hier 'public abstract' void log(...);
     */
    void log( Object loggingClass, String... texts );

    /* default wird hier implementiert, kann aber auch von Unterklassen überschrieben werden.
       Muss aber nicht!
    */
    default String getLoggerName() {
        return "Ich bin eigentlich kein Logger ;-)";
    }
}
