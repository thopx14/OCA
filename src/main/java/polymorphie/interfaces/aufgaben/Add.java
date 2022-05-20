package main.java.polymorphie.interfaces.aufgaben;

public class Add extends IntOperation {

    public Add( int x ) {
        super( x );
    }

    @Override
    public int execute( int x ) {
        return getNumber() + x;
    }
}
