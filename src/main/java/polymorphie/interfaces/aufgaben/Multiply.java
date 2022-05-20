package main.java.polymorphie.interfaces.aufgaben;

public class Multiply extends IntOperation {

    public Multiply( int number ) {
        super( number );
    }

    @Override
    public int execute( int x ) {
        return getNumber() * x;
    }
}
