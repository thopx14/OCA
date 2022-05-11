package main.java.polymorphie.aufgaben.bruteforce;

import java.util.Arrays;

public class Safe {

    private final char[] password;

    public Safe( char[] password ) {
        this.password = password;
    }

    public boolean open( char[] passwordToTry ) {
        return Arrays.equals( this.password, passwordToTry );
    }
}
