package main.java.javaselib;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomThings {
    public static void main( String[] args ) {
        Random random = new Random();
        System.out.println( random.nextInt( 11 ) ); // Pseudozufallszahlen von 0 - 10.
        System.out.println( random.nextInt( 11 ) ); // Pseudozufallszahlen von 0 - 10.

        /*
            Die Klasse Random generiert Pesudozufallszahlen und ist synchronisiert
            (Threadsafe).
            Das kostet. Eine nicht synchronisierte Variante wird wie folgt verwendet
         */
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println( threadLocalRandom.nextInt( 11 ) );

        /*
            Um kryptografisch sichere Zufallszahlen zu generieren, verwendet man
            SecureRandom.
         */
        SecureRandom secureRandom = new SecureRandom();
        System.out.println( secureRandom.getAlgorithm() );
        // Gibt den Algorithmus aus, der verwendet wird
        // Auf unixoiden Systemen wird hier z.B.
        // '/dev/random' oder '/dev/urandom' verwendet.

        /*
            Man kann auch UUID's generieren. Diese sind z.B. zur Benutzerkennung wichtig.
            Sie sind immer eindeutig!
         */
        UUID uuid = UUID.randomUUID();
        System.out.println( uuid );
    }
}
