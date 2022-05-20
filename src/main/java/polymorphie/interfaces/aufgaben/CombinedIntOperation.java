package main.java.polymorphie.interfaces.aufgaben;

public class CombinedIntOperation extends IntOperation {

    IntOperation op1;
    IntOperation op2;

    public CombinedIntOperation( IntOperation op1, IntOperation op2 ) {
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public int execute( int x ) {
        int result = op1.execute( x );
        return op2.execute( result );
    }
}
