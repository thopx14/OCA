package main.java.polymorphie.interfaces.aufgaben;

public class Divide extends IntOperation {

    public Divide( int x ) {
        super( x );
    }

    @Override
    public int execute( int x ) {
        return x / getNumber();
    }
}
