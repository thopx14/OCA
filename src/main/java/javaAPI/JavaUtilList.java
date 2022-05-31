package main.java.javaAPI;

import java.util.ArrayList;
import java.util.List;

public class JavaUtilList {
    public static void main( String[] args ) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add( 12 );
        int what = list1.get( 0 );  // Auto-unboxing!

        ArrayList list2 = list1;    // Zuweisung geht und generischer Typ E geht verloren - wird zu Object!
        list2.add( new Object() );
        list2.add( 45 );            // Autoboxing mit Integer.valueOf(12);
        list2.add( new java.awt.Point() );

        for ( Object o : list2 ) {
            System.out.println( o );
        }

        System.out.println( list2.getClass() );

        kleineAufgabe();

        List<Integer> integerList = new ArrayList<>();
        integerList.add( 10 );
        integerList.add( 11 );
        integerList.add( 12 );
//        integerList.remove( 12  ); IOOB Exception, da remove(int index) aufgerufen wird!

        System.out.println( integerList.size() );

    }

    static void kleineAufgabe() {
        /*
        Speichern Sie folgende Werte in einer neuen ArrayList:
            77, -3, 1000, -11
         */
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add( 77 );
        intList.add( - 3 );
        intList.add( 1000 );
        intList.add( - 11 );

        for ( int i = 0; i < intList.size(); i++ ) {
            System.out.printf( "%d. %d%n", i, intList.get( i ) );
        }

    }
}
