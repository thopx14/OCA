package main.java.javaAPI.aufgaben;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class DateTimeCalendar {
    public static void main( String[] args ) {
        int month;
        int year;

        while(true) {
            try {
                System.out.print("Bitte geben Sie den Monat ein, den Sie ausgegeben haben wollen: ");
                month = new Scanner( System.in ).nextInt();

                System.out.print("Bitte geben Sie das Jahr ein, den Sie ausgegeben haben wollen: ");
                year = new Scanner( System.in ).nextInt();

                if(month > 0 && year > 0) {
                    break;
                }

            } catch ( InputMismatchException e ) {

            }
        }
        try {
            printCalendar( month, year );

        } catch(IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        ###### A1.
        Implementieren Sie eine Methode `printCalendar`,
        mit der der aktuell gesetzte Monat auf der Konsole als eine Tabelle ausgegeben wird:

        		printCalendar(4, 2010); // April 2010

        Für April 2010 soll die Methode `printCalendar` folgende Ausgabe liefern:


		---------------------
		April 2010
		---------------------
		 01 |   Donnerstag  |
		 02 |   Freitag     |
		 03 |   Samstag     |
		...
		 20 |   Dienstag    |
		 21 |   Mittwoch    |
		...
		 30 |   Freitag     |
		---------------------

     */


    static void printCalendar(int month, int year) throws IllegalArgumentException {
        if (month == 0)
            throw new IllegalArgumentException("Monat kann nicht 0 sein!");

        YearMonth ym = YearMonth.of( year, month );
        String fmt = ym.format( DateTimeFormatter.ofPattern( "MMMM uuuu" ) );
        System.out.println("------------------------------------------");
        System.out.println(fmt);

        LocalDate ld = LocalDate.of( ym.getYear(), ym.getMonth(), 1 );
        ArrayList<LocalDate> dateList = new ArrayList<>();
        dateList.add( ld );

        while ( true ) {
            ld = ld.plusDays( 1 );
            // Brich bei Monatswechsel ab
            if (! ld.getMonth().equals( ym.getMonth())) {
                break;
            }
            // Falls kein Monatswechsel, so füge das neue Datum der Liste hinzu
            dateList.add(ld);

        }

        for ( LocalDate localDate : dateList ) {
            System.out.printf("%2d | %15s \t|%n",
                    localDate.getDayOfMonth(),
                    localDate.getDayOfWeek().getDisplayName( TextStyle.FULL, Locale.getDefault() ));
        }
        System.out.println("------------------------------------------");
    }
}
