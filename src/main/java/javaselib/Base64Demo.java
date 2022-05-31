package main.java.javaselib;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Demo {
    public static void main( String[] args ) {
        /*
            Quelle: https://de.wikipedia.org/wiki/Base64

            Zur Kodierung werden die Zeichen A–Z, a–z, 0–9, + und / verwendet sowie = am Ende.
            Padding: Falls die Gesamtanzahl der Eingabebytes nicht durch drei teilbar ist,
            wird der zu kodierende Text am Ende mit aus Nullbits bestehenden Füllbytes aufgefüllt,
            sodass sich eine durch drei teilbare Anzahl an Bytes ergibt.
            Um dem Dekodierer mitzuteilen, wie viele Füllbytes angefügt wurden,
            werden die 6-Bit-Blöcke, die vollständig aus Füllbytes entstanden sind, mit = kodiert.
            Somit können am Ende einer Base64-kodierten Datei kein, ein oder zwei =-Zeichen auftreten.
            Anders gesagt, es werden so viele =-Zeichen angehängt, wie Füllbytes angefügt worden sind.
         */
        byte b[] = {11, 12, 13};
        System.out.println( Base64.getEncoder().encodeToString( b ) ); //CwwN
        byte b2[] = {11, 12, 13, 2};
        System.out.println( Base64.getEncoder().encodeToString( b2 ) ); //CwwNAg==
        byte b3[] = {11, 12, 13, 2, 8};
        System.out.println( Base64.getEncoder().encodeToString( b3 ) ); //CwwNAg==
        System.out.println( Base64.getEncoder().withoutPadding().encodeToString( b3 ) ); //CwwNAgg

        for ( byte b4 : Base64.getDecoder().decode( "Alpaka" ) ) {
            System.out.println( b4 );
        }

        System.out.println( Base64.getEncoder().encodeToString( "Alpakas sind cool".getBytes( StandardCharsets.UTF_8 ) ) ); // QWxwYWthcyBzaW5kIGNvb2w=

    }
}
