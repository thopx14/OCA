package main.java.polymorphie.interfaces.aufgaben;

public abstract class IntOperation {

    private int number;

    public IntOperation() {
    }

    public IntOperation( int number ) {
        this.number = number;
    }

    public abstract int execute( int x );

    public int getNumber() {
        return number;
    }

    public void setNumber( int number ) {
        this.number = number;
    }

    public IntOperation andThen( IntOperation nextOp ) {
        return new CombinedIntOperation( this, nextOp );
    }
}
