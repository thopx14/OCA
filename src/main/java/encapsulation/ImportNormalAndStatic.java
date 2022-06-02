/**
 * @see OCA_Kurs/Kursmaterialien_Patrin/Projekte/PackagesImportsVisibilities/src/regeln/ImportStatic.java
 */

package main.java.encapsulation;

import main.java.encapsulation.p2.ClassPublic;
//import main.java.encapsulation.p1.ClassNotPublic; // cf: Klasse nicht 'public'
import java.util.*;

import static java.lang.Math.PI;
import static java.util.Arrays.*;   // Arrays hat nur statische Methoden. Hier werden alle importiert.

public class ImportNormalAndStatic {
    public static void main( String[] args ) {
        /*
            Geht alles!
         */
        ClassPublic cp = new ClassPublic();
        Auto a1 = new Auto();   // Okay, da aus selben Paket!
        java.util.ArrayList<String> arrayList;

        ArrayList<Float> floats;    // Okay, da importiert mit java.util.*

//        Predicate<Double> p1; // cf: Geht nicht, da nicht importiert!

        /*
         ********************
         * Statische Imports
         * *******************
         */
        System.out.println( PI );       // Math.PI wurde statisch importiert!
        System.out.println( Math.PI );  // Geht genauso!
        int[] arr = {1, 2, 3, 4};

        sort( arr );  // Kommt aus java.util.Arrays und wurde statisch importiert!
        java.util.Arrays.sort( arr );  // Geht weiterhin.

    } // end of main
}
