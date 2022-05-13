package main.java.polymorphie.aufgaben.bruteforce;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class BruteForceDictionary extends Bruteforce {

    public BruteForceDictionary( Safe safe, Loggable logger ) {
        super( safe, logger );
    }

    @Override
    public boolean bruteforce() {
        // Load passwords.txt
        String passwords = "passwords.txt";
        try ( BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                getClass().getResourceAsStream( passwords ) ) ) ) ) {

            String text = "";
            while ( text != null ) {
                text = reader.readLine();
                if ( text != null ) {
                    char[] pwToTest = text.strip().toCharArray();
                    if ( getSafe().open( pwToTest ) ) {
                        getLogger().log( this, "Found password ", Arrays.toString( pwToTest ) );
                        return true;
                    }
                }
            }

        } catch ( IOException e ) {
            getLogger().log( "Fehler beim Lesen von: ", passwords, " ", e.getMessage() );
        }
        return false;
    }
}
