package main.java.encapsulation.rennen;

import main.java.encapsulation.Auto;

public class Rennwagen extends Auto {
    public static void main( String[] args ) {
        Rennwagen a1 = new Rennwagen();
//        System.out.println( a1.manufacturer );      // cf: 'private' Zugriff nicht möglich!
        System.out.println( a1.shortName );           // Ok!
        System.out.println( a1.model );               // Ok!
//        System.out.println( a1.dateOfManufacturing ); // NOk! -> package visible!

        Auto a2 = new Rennwagen();
//        System.out.println( a2.manufacturer );      // cf: 'private' Zugriff nicht möglich!
        System.out.println( a2.shortName );           // Ok!

        /*	protected			sichtbar überall im eigenen Package
         * 						UND:
         * 						in allen abgeleiteten Klassen, auch
         * 						wenn sie sich in anderen Packages befinden,
         * 						aber NUR mit Referenzen von abgeleiteten Typen
         * 						(s. autos.Rennen)
         */

        // zwar sind wir gerade in
        // der abgeleiteten Klasse,
        // aber der Zugriff erfolgt
        // nicht über Referenz vom
        // abgeleiteten Typ
//        System.out.println( a2.model );   // cf


    }
}
