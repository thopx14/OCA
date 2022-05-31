package main.java.javaselib;

import java.util.Currency;
import java.util.Locale;

public class LocaleCurrency {
    public static void main( String[] args ) {

        /*
            Was für Locale-Objekte gibt es.
         */
        for ( Locale locale : Locale.getAvailableLocales() ) {
            System.out.printf( "%s %s %s%n", locale, locale.getDisplayCountry(), locale.getDisplayName() ); // z.B. cs_CZ Tschechien Tschechisch (Tschechien)
        }

        System.out.printf( Locale.GERMANY, "%,f%n", Math.random() * 100000 );       // 56.760,169302
        System.out.printf( Locale.US, "%,f%n", Math.random() * 100000 );            // 46,870.716905
        System.out.printf( Locale.CHINA, "%,f%n", Math.random() * 100000 );         // 36,307.492159
        System.out.printf( Locale.FRANCE, "%,f%n", Math.random() * 100000 );        // 2 347,163300

        for ( Currency currency : Currency.getAvailableCurrencies() ) {
            System.out.println( currency.getDisplayName() + " " + currency.getCurrencyCode() );
        }
    }
}
