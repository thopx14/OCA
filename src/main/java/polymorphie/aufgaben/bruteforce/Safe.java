package main.java.polymorphie.aufgaben.bruteforce;

import java.util.Arrays;

/*
Wird vom Compiler so umgesetzt:
===================================
public final class main.java.polymorphie.aufgaben.bruteforce.Safe extends java.lang.Record {
  public main.java.polymorphie.aufgaben.bruteforce.Safe(char[]);
  public boolean open(char[]);
  public char[] password();
  public final java.lang.String toString();
  public final int hashCode();
  public final boolean equals(java.lang.Object);
}
 */

public record Safe(char[] password) {

    public boolean open( char[] passwordToTry ) {
        return Arrays.equals( password, passwordToTry );
    }

    @Override
    public char[] password() {
        return new char[]{'H', 'I', 'D', 'D', 'E', 'N'};
    }

}
