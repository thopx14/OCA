package main.java.polymorphie.interfaces.aufgaben;

public class ChangeSign extends IntOperation {

    public ChangeSign() {
    }

    public ChangeSign( int number ) {
        super( number );
    }

    @Override
    public int execute( int x ) {
        return x * - 1;
    }
}
