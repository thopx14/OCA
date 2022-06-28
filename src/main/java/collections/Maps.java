package main.java.collections;

import java.util.*;

public class Maps {
    public static void main( String[] args ) {
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put( 12, "Hallo" );
        myMap.put( 12, "Welt" );
        myMap.put( 15, "Welt" );
        myMap.put( 22, "Welt" );
        myMap.put( 52, "Welt" );

        System.out.println( "HashMap" );
        Set<Integer> kSet = myMap.keySet();
        for ( int k : kSet )
            System.out.print( k + " " ); // 52 22 12 15

        Map<Integer, String> myMap2 = new LinkedHashMap<>();
        myMap2.put( 12, "Hallo" );
        myMap2.put( 22, "Hallo" );
        myMap2.put( 52, "Hallo" );
        myMap2.put( 72, "Hallo" );
        myMap2.put( 99, "Hallo" );

        System.out.println();
        System.out.println( "LinkedHashMap" );
        for ( Integer i : myMap2.keySet() ) {
            System.out.print( i + " " );
        }

        // ClassCastException! LinkedHashMap IS-NOT NavigableMap!
//        NavigableMap<Integer, String> nMap = ( NavigableMap<Integer, String> ) myMap2;

        System.out.println();
        enum COLOR {RED, GREEN, BLUE}
        NavigableMap<COLOR, String> nMap = new TreeMap<>();
        nMap.put( COLOR.RED, "0xff0000" );
        nMap.put( COLOR.GREEN, "0x00ff00" );
        nMap.put( COLOR.BLUE, "0x0000FF" );

        System.out.println( nMap.ceilingKey( COLOR.RED ) ); // RED
        System.out.println( nMap.floorKey( COLOR.RED ) ); // RED
        System.out.println( nMap.higherKey( COLOR.RED ) ); // GREEN
        System.out.println( nMap.lowerKey( COLOR.RED ) ); // null

    }
}
