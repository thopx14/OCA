package main.java.polymorphie.aufgaben.bruteforce;

import java.util.Arrays;

public class SimpleBruteForce extends Bruteforce {

    private final char[][] commonPWs = {
            {'a', 'b', 'c', 'd'},
            {'1', '2', '3', '4'},
            {'p', 'a', 's', 's'},
            {'s', 'p', 'a', 's'}
    };

    public SimpleBruteForce( Safe safe, Logging logger ) {
        super( safe, logger );
    }

    @Override
    public boolean bruteforce() {
        for ( char[] commonPW : this.commonPWs ) {
            if ( this.getSafe().open( commonPW ) ) {
                this.getLogger().log( this, "Found password: ", Arrays.toString( commonPW ) );
                return true;
            }
        }
        return false;
    }
}
