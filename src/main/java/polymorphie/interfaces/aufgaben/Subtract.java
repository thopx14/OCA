package main.java.polymorphie.interfaces.aufgaben;

public class Subtract extends IntOperation {

    public Subtract( int x ) {
        super( x );
    }

    @Override
    public int execute( int x ) {
        return x - getNumber();
    }
}
