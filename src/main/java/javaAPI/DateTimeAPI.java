package main.java.javaAPI;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeAPI {
    public static void main( String[] args ) {

        /*
            Quelle: https://github.com/ullenboom/java-held-lectures-material.git
           Typ             	  Jahr  Monat	  Tag	  Std.	Min.	Sek.	Zeitzonen-Offset	Zonen-ID
            ====================================================================================
            LocalDate						 ✔      ✔     ✔
            LocalTime                                ✔     ✔    ✔
            LocalDateTime        ✔      ✔     ✔     ✔     ✔    ✔

            OffsetTime                                ✔     ✔    ✔           ✔
            OffsetDateTime        ✔      ✔     ✔     ✔     ✔    ✔           ✔
            ZonedDateTime         ✔      ✔     ✔     ✔     ✔    ✔           ✔            ✔
    */

        // Enthält nur Datumswerte (Jahr, Monat, Tag)
        LocalDate now = LocalDate.now();
        System.out.println( now );

        // Enthält nur Zeitwerte (Stunde, Minute, Sekunde, Millisekunde)
        System.out.println( LocalTime.now() );

        // Enthält LocalDate + LocalTme
        System.out.println( LocalDateTime.now() );

        // Enthält zusätzlich noch die Zeitzone
        System.out.println( ZonedDateTime.now() );

        // Spezielle Daten erzeugen:
        LocalDateTime christmas = LocalDateTime.of( 2022, Month.DECEMBER, 24, 21, 30 );
        System.out.println( christmas );
        System.out.println( christmas.plusHours( 1 ) );
        System.out.println( christmas.minusHours( 1 ) );
        System.out.println( christmas.atOffset( ZoneOffset.ofHours( + 2 ) ) );
        System.out.println( christmas.atZone( ZoneId.of( "Europe/Berlin" ) ) );
//        System.out.println( christmas.atZone( ZoneId.of( "Europe/Berli" ) ) ); //Exception in thread "main" java.time.zone.ZoneRulesException: Unknown time-zone ID: Europe/Berli
        System.out.println( christmas.format( DateTimeFormatter.ISO_DATE_TIME ) );
//        System.out.println( christmas.format( DateTimeFormatter.ofLocalizedDateTime( FormatStyle.FULL ) ) ); // Geht nicht, da kein ZoneDateTime-Objekt. Keine Zonen-ID vorhanden.
        System.out.println( christmas.format( DateTimeFormatter.ofLocalizedDateTime( FormatStyle.MEDIUM ) ) );
        System.out.println( christmas.format( DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT ) ) );
//        System.out.println( christmas.format( DateTimeFormatter.ofLocalizedDateTime( FormatStyle.LONG ) ) ); // Geht nicht, da kein ZoneDateTime-Objekt. Keine Zonen-ID vorhanden.
        System.out.println( christmas.format( DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT ).withLocale( Locale.ENGLISH ) ) );
        System.out.println( christmas.format( DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT ).withLocale( Locale.FRENCH ) ) );
        System.out.println( christmas.format( DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT ).withLocale( Locale.CHINESE ) ) );
        System.out.println( christmas.format( DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT ).withLocale( Locale.JAPAN ) ) );


    }
}
