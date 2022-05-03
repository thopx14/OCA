package main.java.arrays.aufgaben;

public class HafenVollException extends Exception {

    public HafenVollException(String msg) {
        super(msg);
    }
    public HafenVollException() {
        super( "Leider ist der Hafen jetzt voll!" );
    }
}
