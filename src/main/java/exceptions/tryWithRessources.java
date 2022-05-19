package main.java.exceptions;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

public class tryWithRessources {

    public static void main( String[] args ) {

        /*
        PrintWriter implementiert AutoClosable. Das bedeutet, dass automatisch im Bytecode ein
        finally-Block erzeugt wird:

        finally {
            printWriter.close();
        }

        Falls es mehr als ein Object gibt, z.B. wie unten mit Scanner wird im 'finally' wie folgt geschlossen:

        finally {
            printWriter.close();
            sc.close();
        }
        Also von unten nach oben!!
         */
        try ( Scanner sc = new Scanner( Paths.get( "ausgabe.txt" ) );
              PrintWriter printWriter = new PrintWriter( "ausgabe2.txt", StandardCharsets.UTF_8 ) ) {

            while ( sc.hasNextLine() ) {
                printWriter.println( sc.nextLine().toUpperCase() );
            }

        } catch ( IOException e ) {
            e.printStackTrace();
        }

        /*
        Test der eigenen AutoCloseable Klassen.
         */

        try ( Output o = new Output();
              Input i = new Input() ) {
            System.out.println( "Rumpf von Methode" );
            System.out.println( 1 / 0 );
            /*
            Ausgabe:
                Rumpf von Methode
                Input closed --> Input wird auf jeden Fall geschlossen, auch wenn in der close Methode
                                 von Output eine Ausnahme vorkommt!
                ** Stack-Trace (siehe unten)
             */
        } catch ( ArithmeticException e ) {
            /*
            Da die Methode close() in Output eine ArithmeticException wirft
            und im Rumpf unseres try-mit-Ressourcen Blockes ebenfalls eine ArithmeticException
            geworfen wird, wird die ArithmeticException von Output 'unterdrückt' ('suppressed').
            Sie wird quasi Huckepack an die Exception im Rumpf angehängt und zusammen ausgegeben.
            Siehe Stack-Trace:
            ----------------------------
            Rumpf von Methode
            Input closed
            java.lang.ArithmeticException: / by zero
                at main.java.exceptions.TryWithRessources.main(TryWithRessources.java:47)
         --->   Suppressed: java.lang.ArithmeticException: / by zero
                    at main.java.exceptions.Output.close(TryWithRessources.java:64)
                    at main.java.exceptions.TryWithRessources.main(TryWithRessources.java:44)
             */
            e.printStackTrace();
        }
    }
}

class Output implements AutoCloseable {

    @Override
    public void close() {
        System.out.println( 1 / 0 );
        System.out.println( "Output closed" );
    }
}

class Input implements AutoCloseable {

    @Override
    public void close() {
        System.out.println( "Input closed" );
    }
}
