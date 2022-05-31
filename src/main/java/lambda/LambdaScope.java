package main.java.lambda;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

public class LambdaScope {
    public static void main( String[] args ) {
        final boolean trimBefore = true;
        // Das geht nicht! Methoden müssen final oder effektive final sein.
        // Sie dürfen nicht mehr geändert werden nach dem Initialisieren.
//        trimBefore = false;
        Predicate<String> isEmpty = ( String s ) -> trimBefore ? s.trim().isEmpty() : s.isEmpty();

        Predicate<Path> isEmptyPath = p -> {
            try {
                return Files.size( p ) == 0;

            } catch ( IOException e ) {
                /*
                    Hier muss eine ungeprüfte Exception geworfen werden, da die Methode 'test' aus
                    Predicate keine Exception wirft.
                 */
                throw new UncheckedIOException( e );
            }
        };

        /*
            Exception in thread "main" java.io.UncheckedIOException: java.nio.file.NoSuchFileException: abcdefg
	            at main.java.lambda.LambdaScope.lambda$main$1(LambdaScope.java:28)
	            at main.java.lambda.LambdaScope.main(LambdaScope.java:32)

	            !!! Die Exception wird einfach an die darüber gelegenen Methode weitergeleitet (in diesem Fall die main Methode).
         */
        isEmptyPath.test( Paths.get( "abcdefg" ) );

        /*
            So sähe das ganze als anonyme innere Klasse aus. Hier sieht man in der Methoden-Signatur,
            dass die Methode keine Exception wirft und somit ein 'throws' einer geprüften Ausnahme nicht
            funktionieren würde.
         */
        Predicate<Path> isEmptyPath2 = new Predicate<Path>() {
            @Override
            public boolean test( Path p ) {
                try {
                    return Files.size( p ) == 0;

                } catch ( IOException e ) {
                /*
                    Hier muss eine ungeprüfte Exception geworfen werden, da die Methode 'test' aus
                    Predicate keine Exception wirft.
                 */
                    throw new UncheckedIOException( e );
                }
            }
        };

        /*
            Hier ist es kein Problem, da die Methoden-Signatur schon eine 'Exception' wirft.
            'IOException' ist ja eine Unterklasse von 'Exception'.
         */
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                long size = Files.size( Paths.get( "" ) );
                return "";
            }
        };

        /*
            Das selbe als Lambda!
         */
        Callable<String> callable2 = () -> {
            long size = Files.size( Paths.get( "" ) );
            return "";
        };
    }
}
