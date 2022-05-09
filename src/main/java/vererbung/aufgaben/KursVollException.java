package main.java.vererbung.aufgaben;

public class KursVollException extends Exception {

    public KursVollException( int id, String name ) {
        super( "Kurs (" + id + "): '" + name + "' ist leider voll!" );
    }
}
