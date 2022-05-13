package main.java.polymorphie.aufgaben.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteforceHeap extends Bruteforce {

    private final char[][] pwToPermute = {
            {'a', 'b', 'c', 'd'},
            {'1', '2', '3', '4'}
    };

    public BruteforceHeap( Safe safe, Loggable logger ) {
        super( safe, logger );
    }

    @Override
    public boolean bruteforce() {
        ArrayList<String> permutationOfPWs = new ArrayList<>();
        for ( char[] chars : this.pwToPermute ) {
            permutationByHeap( permutationOfPWs, chars, chars.length );
            // Nachdem die Methode zurückgekehrt ist, soll geprüft werden, ob ein pw davon den Safe knackt!
            for ( String permutationOfPW : permutationOfPWs ) {
                char[] converted = permutationOfPW.toCharArray();
                if ( getSafe().open( converted ) ) {
                    getLogger().log( this, "Found password: ", Arrays.toString( converted ) );
                    return true;
                }
            }
        }

        // Wenn nichts gefunden wurde, dann gibt 'false' zurück.
        return false;
    }

    private void permutationByHeap( ArrayList<String> output, char[] arr, int pointer ) {

        if ( pointer == 1 ) {
            output.add( String.valueOf( arr ) );
            return;
        }

        for ( int i = 0; i < pointer - 1; i++ ) {
            permutationByHeap( output, arr, pointer - 1 );

            if ( pointer % 2 == 0 ) {
                char tmp = arr[pointer - 1];
                arr[pointer - 1] = arr[i];
                arr[i] = tmp;
            } else {
                char tmp = arr[pointer - 1];
                arr[pointer - 1] = arr[0];
                arr[0] = tmp;
            }
        }

        permutationByHeap( output, arr, pointer - 1 );
    }
}
